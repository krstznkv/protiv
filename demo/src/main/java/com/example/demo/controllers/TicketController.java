package com.example.demo.controllers;

import com.example.demo.entity.Request;
import com.example.demo.entity.Ticket;
import com.example.demo.entity.mego.MegoRequest;
import com.example.demo.entity.platov.PlatovRequest;
import com.example.demo.entity.platov.PlatovTicket;
import com.example.demo.services.AllTicketsService;
import com.example.demo.services.TicketService;
import com.example.demo.services.impl.MegoTravell;
import com.example.demo.services.impl.Platov;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
//@RequestMapping("tickets")
@RequiredArgsConstructor
public class TicketController {
  //private final MegoTravell megoTravell;
   private final Platov platov;
   // private final AllTicketsService allTicketsService;
    @PostMapping("find")
    public ResponseEntity<List<Ticket>> findTickets(@RequestBody Request request){
        return ResponseEntity.ok(platov.getTickets(request));
    }
   

}
