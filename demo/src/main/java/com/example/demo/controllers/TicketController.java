package com.example.demo.controllers;

import com.example.demo.entity.Request;
import com.example.demo.entity.Ticket;
import com.example.demo.entity.mego.MegoRequest;
import com.example.demo.entity.platov.PlatovRequest;
import com.example.demo.entity.platov.PlatovTicket;
import com.example.demo.services.AllTicketsService;
import com.example.demo.services.TicketService;
import com.example.demo.services.impl.Platov;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("tickets")
@RequiredArgsConstructor
public class TicketController {
   // private final TicketService ticketService;
  //  private final Platov platov;
    private final AllTicketsService allTicketsService;
    @PostMapping("find")
    public ResponseEntity<Set<Ticket>> findTickets(Request request){
        return ResponseEntity.ok(allTicketsService.findAll(request));
    }
   

}