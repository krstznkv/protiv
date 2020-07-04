package com.example.demo.services.impl;

import com.example.demo.entity.Request;
import com.example.demo.entity.Ticket;
import com.example.demo.entity.mego.MegoRequest;
import com.example.demo.entity.mego.MegoTicket;
import com.example.demo.repo.AirportRepo;
import com.example.demo.services.TicketService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    AirportRepo airportRepo;
    String uid;
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
        char [] date= new char[4];
        date[0] = r.getDate().charAt(5);
        date[1]=r.getDate().charAt(6);
        date[2]=r.getDate().charAt(8);
        date[3]=r.getDate().charAt(9);
        String dateArrive=new String(date);

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
                        .findValue("iataCode")
                        .toString());
                megoTicket.setArrivalAir(jsonNode
                        .findValue("destinations")
                        .findValue(megoTicket.getArrivalDestinationUID())
                        .findValue("iataCode")
                        .toString());
                if(i==0) uid=megoTicket.getArrivalDestinationUID();
                Ticket ticket=new Ticket();
                ticket.setLink("https://mego.travel/flights/"+r.getFrom()+
                        "/"+r.getTo()+
                        "/"+dateArrive+"/100/e");
                ticket.setAirline(megoTicket.getAirline());
                String from= megoTicket.getArrivalAir();
                String to=megoTicket.getDepartureAir();
                ticket.setArrivalAir(airportRepo.findByCode(from.substring(1,from.length()-1)).getName_air());
                ticket.setDepartureAir(airportRepo.findByCode(to.substring(1,to.length()-1)).getName_air());
                ticket.setDepartureDate(megoTicket.getDepartureDate());
                ticket.setArrivalDate(megoTicket.getArrivalDate());
                ticket.setPrice(megoTicket.getBillingPrice());
                if(megoTicket.getArrivalDestinationUID().equals(uid))
                tickets.add(ticket);
            }
            return tickets;
        } catch (JsonProcessingException e) {
            log.error("error when parsing response",e);
        }
        return null;
    }
}
