package com.example.demo.controllers;

import com.example.demo.entity.Request;
import com.example.demo.entity.Ticket;
import com.example.demo.entity.mego.MegoRequest;
import com.example.demo.entity.platov.PlatovRequest;
import com.example.demo.entity.platov.PlatovTicket;
import com.example.demo.entity.report.AirlineTop;
import com.example.demo.repo.AirlineTopRepo;
import com.example.demo.repo.TicketRepository;
import com.example.demo.services.AllTicketsService;
import com.example.demo.services.TicketDBService;
import com.example.demo.services.TicketService;
import com.example.demo.services.impl.MegoTravell;
import com.example.demo.services.impl.Platov;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
//@RequestMapping("tickets")
@RequiredArgsConstructor
public class TicketController {
 // private final MegoTravell megoTravell;
  // private final Platov platov;
    private final TicketDBService ticketDBService;
    private final AllTicketsService allTicketsService;

    @Autowired
    AirlineTopRepo airlineTopRepo;
    @PostMapping("find")
    public ResponseEntity<Set<Ticket>> findTickets(@RequestBody Request request){
        return ResponseEntity.ok(allTicketsService.findAll(request));
    }
    @PostMapping("saveTicket")
    public ResponseEntity<Ticket> saveTicket(@RequestBody Ticket ticket){
        return ResponseEntity.ok(ticketDBService.save(ticket));
    }
   /* @PostMapping("report")
    public ResponseEntity<List<AirlineTop>> findTop(){
        return ResponseEntity.ok(airlineTopRepo.findTop());
    }*/


   

}
