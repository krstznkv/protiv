package com.example.demo.entity.report;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@SqlResultSetMapping(
        name="AirlineResult",
        classes={
                @ConstructorResult(
                        targetClass=com.example.demo.entity.report.AirlineTop.class,
                        columns={
                                @ColumnResult(name="airline" ),
                                @ColumnResult(name="countOfTicket", type=Integer.class)})})
@NamedNativeQuery(name = "Airlines",
        query = "SELECT airline , COUNT(id) as countOfTicket FROM ticket GROUP BY airline",
        resultSetMapping = "AirlineResult")
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class AirlineTop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JsonProperty("airline")
    private String airline;
    @JsonProperty("countOfTicket")
    private Integer countOfTicket;

    public AirlineTop() {
    }
    public AirlineTop(Long id,String airline,Integer countOfTicket) {
        this.airline=airline;
        this.id=id;
        this.countOfTicket=countOfTicket;
    }
    public AirlineTop(String airline,Integer countOfTicket) {
        this.airline=airline;

        this.countOfTicket=countOfTicket;
    }

}
