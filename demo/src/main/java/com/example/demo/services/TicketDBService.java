package com.example.demo.services;

import com.example.demo.entity.Ticket;
import com.example.demo.entity.User;
import com.example.demo.entity.report.AirlineTop;
import com.example.demo.entity.report.TicketDB;
import com.example.demo.repo.AirportRepo;
import com.example.demo.repo.TicketDBRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class TicketDBService {
    @Autowired
    TicketDBRepo ticketRepository;
    @Autowired
    AirportRepo airportRepo;
    @PersistenceContext
    private  EntityManager em;
   


    public List<AirlineTop> findTop(){
        List<AirlineTop> list= em.createNamedQuery("Airlines",AirlineTop.class).getResultList();
        if(list==null) throw new IllegalArgumentException("oh");
        return list;
    }
    public TicketDB save(Ticket ticket, User user){
        TicketDB ticketDB=new TicketDB(ticket);
         ticketDB.setDepartureAir(airportRepo.findByName(ticket.getDepartureAir()));
         ticketDB.setArrivalAir(airportRepo.findByName(ticket.getArrivalAir()));
         ticketDB.setUser(user);
        return ticketRepository.save(ticketDB);
    }

}
