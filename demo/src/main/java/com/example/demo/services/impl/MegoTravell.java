package com.example.demo.services.impl;

import com.example.demo.entity.Request;
import com.example.demo.entity.Ticket;
import com.example.demo.entity.mego.MegoRequest;
import com.example.demo.entity.mego.MegoTicket;
import com.example.demo.services.TicketService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class MegoTravell implements TicketService {
    private final RestTemplate restTemplate=new RestTemplate();
    private ObjectMapper objectMapper=new ObjectMapper();
    @Value("${service.mego}")
    String url;
    @Override
    public List<Ticket> getTickets(Request r) {
        MegoRequest megoRequest=new MegoRequest();
        megoRequest.setAdults(r.getAdult());
        megoRequest.setChildren(r.getChildren());
        MegoRequest.Section section=new MegoRequest.Section();
        section.setDate(r.getDate()+"T00:00:00");
        section.setFrom(r.getFrom());
        section.setTo(r.getTo());
        List<MegoRequest.Section> list=new ArrayList<>();
        list.add(section);
        megoRequest.setSections(list);
        megoRequest.setAppId("C5E23A9A58F2C1E9CA7B0F594813719C0458EF08");
        megoRequest.setAppSecret("AD73681BC741FDEDF388EF7332546DCC17001C5500CC2E99608B76BA9BD626D2");
        megoRequest.setIsRangeSearch(false);
        megoRequest.setBabies(0);
        megoRequest.setBookingClass("Economic");
        megoRequest.setLocale("ru");
        megoRequest.setPartnerCookie("t=1");
        megoRequest.setTheme("mego");

        HttpEntity<MegoRequest> httpEntity=new HttpEntity<MegoRequest>(megoRequest);
        String response=restTemplate
                .exchange(url, HttpMethod.POST,httpEntity,String.class)
                .getBody();
        try {
            JsonNode jsonNode=objectMapper.readTree(response);
            List<Ticket> tickets =new ArrayList<>();
            List<JsonNode> segments=jsonNode.findValues("segments");
            for (int i=0;i<segments.size();i++){
                MegoTicket megoTicket =objectMapper.readValue(segments.get(i).get(0).toString(), MegoTicket.class);
                megoTicket.setBillingPrice(jsonNode.findValue("flights").get(i).findValue("billingPrice").toString());
                megoTicket.setAirline(jsonNode.findValue("airlines").findValue(megoTicket.getAirlineUID()).findValue("name").toString());
                megoTicket.setDepartureAir(jsonNode
                        .findValue("destinations")
                        .findValue(megoTicket.getDepartureDestinationUID())
                        .findValue("localizedName")
                        .toString());
                megoTicket.setArrivalAir(jsonNode
                        .findValue("destinations")
                        .findValue(megoTicket.getArrivalDestinationUID())
                        .findValue("localizedName")
                        .toString());
                Ticket ticket=new Ticket();
                ticket.setAirline(megoTicket.getAirline());
                ticket.setArrivalAir(megoTicket.getArrivalAir());
                ticket.setDepartureAir(megoTicket.getDepartureAir());
                ticket.setDepartureDate(megoTicket.getDepartureDate());
                ticket.setArrivalDate(megoTicket.getArrivalDate());
                ticket.setPrice(megoTicket.getBillingPrice());
                tickets.add(ticket);
            }
            return tickets;
        } catch (JsonProcessingException e) {
            log.error("error when parsing response",e);
        }
        return null;
    }
}