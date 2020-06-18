package com.example.demo.services;

import com.example.demo.entity.Message;
import com.example.demo.entity.Ticket;
import com.example.demo.entity.User;
import com.example.demo.entity.report.AirlineTop;
import com.example.demo.repo.TicketRepository;
import com.example.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class TicketDBService {
    @Autowired
    TicketRepository ticketRepository;
    @PersistenceContext
    private  EntityManager em;
   


    public List<AirlineTop> findTop(){
        List<AirlineTop> list= em.createNamedQuery("Airlines",AirlineTop.class).getResultList();
        if(list==null) throw new IllegalArgumentException("oh");
        return list;
    }
    public Ticket save(Ticket ticket){
        return ticketRepository.save(ticket);
    }

}
