package com.example.demo.services;

import com.example.demo.entity.Ticket;
import com.example.demo.entity.User;
import com.example.demo.repo.TicketRepository;
import com.example.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Service
public class TicketDBService {
    @Autowired
    TicketRepository ticketRepository;
    private static EntityManager em;
    private static EntityManagerFactory emFactory;
    
    public Ticket save(Ticket ticket){
        return ticketRepository.save(ticket);
    }

}
