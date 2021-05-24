package com.example.demo.entity;

import com.example.demo.entity.Station;
import lombok.Data;
import org.springframework.core.io.Resource;

import javax.persistence.*;
@MappedSuperclass
@Data
abstract public class ReportBase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="station_id")
    private Station station;
    private int year;
    private int month;
    private boolean approveByDirector;
}
