package com.example.demo.entity.report;

import lombok.Data;

import javax.persistence.*;

@SqlResultSetMapping(
        name="AirlineResult",
        classes={
                @ConstructorResult(
                        targetClass=com.example.demo.entity.report.AirlineTop.class,
                        columns={
                                @ColumnResult(name="airline" ),
                                @ColumnResult(name="dayOfWeek", type=Integer.class)})})
@NamedNativeQuery(name = "Airlines",
        query = "SELECT airline , COUNT(id) FROM ticket GROUP BY airline",
        resultSetMapping = "AirlineResult")
@Entity
@Data
public class AirlineTop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String airline;
    private Integer countOfTicket;
}
