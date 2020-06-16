package com.example.demo.services.impl;

import com.example.demo.entity.Request;
import com.example.demo.entity.Ticket;
import com.example.demo.entity.platov.PlatovTicket;
import com.example.demo.services.TicketService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class Platov implements TicketService {
    private final RestTemplate restTemplate=new RestTemplate();
    private ObjectMapper objectMapper=new ObjectMapper();
    @Override
    public List<Ticket> getTickets(Request r) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("https://ps.biletix.ru/api/get_tariffs/")
                .queryParam("newbackend", "1")
                .queryParam("date", "717")
                .queryParam("from", r.getFrom())
                .queryParam("to", r.getTo())
                .queryParam("dep_date",r.getDate())
                .queryParam("ret_date", "")
                 .queryParam("adults", r.getAdult())
                .queryParam("children", r.getChildren())
                .queryParam("infants", 0)
                .queryParam("service_class", "E")
                 .queryParam("lid", "")
                .queryParam("only_direct", "N")
                .queryParam("lang", "en")
                .queryParam("session_token", "null")
                .queryParam("altDomain", "rnd-airport.ru")
                .queryParam("currentCurrency", "RUR");


        HttpEntity<?> entity = new HttpEntity<>(headers);
        String response=restTemplate
                .exchange(builder.toUriString(),
                        HttpMethod.GET,
                        entity,
                        String.class)
                .getBody();
     try {
            JsonNode jsonNode=objectMapper.readTree(response);
            List<Ticket> tickets =new ArrayList<>();
            List<JsonNode> trips=jsonNode.findValues("trips");
           // List<JsonNode> segments=jsonNode.findValues("segments");
            List<JsonNode> prices=jsonNode.findValues("price");
            List<JsonNode> links=jsonNode.findValues("deep_link");
            for (int i=0;i<trips.size();i++){
                PlatovTicket platovTicket =objectMapper.readValue(trips.get(i).findValue("segments").get(0).toString(), PlatovTicket.class);
               platovTicket.setPrice(prices.get(i).toString());
               Ticket ticket=new Ticket();
               ticket.setArrivalDate(platovTicket.getArrivalTime());
               ticket.setDepartureDate(platovTicket.getDepartureTime());
               ticket.setDepartureAir(platovTicket.getDeparture().getName());
               ticket.setArrivalAir(platovTicket.getArrival().getName());
               ticket.setPrice(platovTicket.getPrice());
               ticket.setAirline(platovTicket.getAirline().getName());
               ticket.setLink(links.get(i).toString());
                tickets.add(ticket);
            }
            return tickets;
        } catch (JsonProcessingException e) {
            log.error("error when parsing response",e);
        }
        log.error(response);
        return null;
    }
}
