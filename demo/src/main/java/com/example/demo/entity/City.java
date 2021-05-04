package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique=true)
    private String code;

    private String name;

    public City() {

    }

    public City(String code, String name) {
        this.code=code;
        this.name=name;
    }
}
