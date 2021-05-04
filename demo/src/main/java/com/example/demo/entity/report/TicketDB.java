package com.example.demo.entity.report;

import com.example.demo.entity.Airport;
import com.example.demo.entity.Ticket;
import com.example.demo.entity.User;
import lombok.Data;

import javax.persistence.*;
@Data
@Entity
public class TicketDB {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String departureDate;
    private String arrivalDate;
    private String price;
    private String airline;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "airportDep_id")
    private Airport departureAir;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "airportArr_id")
    private Airport arrivalAir;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    public TicketDB(Ticket ticket){
        this.airline=ticket.getAirline();
        this.arrivalDate=ticket.getArrivalDate();
        this.departureDate=ticket.getDepartureDate();
        this.price=ticket.getPrice();
    }
}
