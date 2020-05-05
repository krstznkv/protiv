package com.example.demo.services;

import com.example.demo.entity.Request;
import com.example.demo.entity.Ticket;


import java.util.List;

public interface TicketService {
    List<Ticket> getTickets(Request r);
}
