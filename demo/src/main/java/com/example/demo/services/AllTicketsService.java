package com.example.demo.services;

import com.example.demo.entity.Request;
import com.example.demo.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AllTicketsService {
    @Autowired
    List<TicketService> services;
    public Set<Ticket> findAll(Request r){
        Set<Ticket> allTickets=new HashSet<>();
        for (TicketService t:services
             ) {
            List<Ticket> tickets=t.getTickets(r);
            allTickets.addAll(tickets);
        }
        return allTickets;
    }
}
