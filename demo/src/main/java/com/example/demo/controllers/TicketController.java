package com.example.demo.controllers;

import com.example.demo.entity.City;
import com.example.demo.entity.Request;
import com.example.demo.entity.Ticket;
import com.example.demo.entity.report.AirlineTop;
import com.example.demo.repo.CityRepo;
import com.example.demo.services.AllTicketsService;
import com.example.demo.services.TicketDBService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;
@CrossOrigin(origins = "http://localhost:4200")
@RestController

@RequiredArgsConstructor
public class TicketController {
    private final TicketDBService ticketDBService;
    private final AllTicketsService allTicketsService;
    private final CityRepo cityRepo;
    @PostMapping("find")
    public ResponseEntity<Set<Ticket>> findTickets(@RequestBody Request request){
        City from=cityRepo.findByName(request.getFrom());
        City to=cityRepo.findByName(request.getTo());
        request.setFrom(from.getCode());
        request.setTo(to.getCode());
        return ResponseEntity.ok(allTicketsService.findAll(request));
    }
    @PostMapping("saveTicket")
    public ResponseEntity<Ticket> saveTicket(@RequestBody Ticket ticket){
        return ResponseEntity.ok(ticketDBService.save(ticket));
    }
    @PostMapping("test")
    public ResponseEntity<List<AirlineTop>> findTop(){

        return ResponseEntity.ok(ticketDBService.findTop());
    }


   

}
