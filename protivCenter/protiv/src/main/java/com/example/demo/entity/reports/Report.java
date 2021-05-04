package com.example.demo.entity.reports;

import com.example.demo.entity.Station;
import lombok.Data;

import javax.persistence.*;
@Data
abstract public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="station_id")
    private Station station;
    private int year;
    private int month;
}
