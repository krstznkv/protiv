package com.example.demo.entity.platov;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "arrival",
        "arrival_time",
        "departure",
        "departure_time",
        "airline"
})
public class PlatovTicket {
    @JsonProperty("price")
    private String price;
    @JsonProperty("arrival")
    private Arrival arrival;
    @JsonProperty("arrival_time")
    private String arrivalTime;
    @JsonProperty("departure")
    private Departure departure;
    @JsonProperty("departure_time")
    private String departureTime;
    @JsonProperty("airline")
    private Airline airline;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("arrival")
    public Arrival getArrival() {
        return arrival;
    }
    @JsonProperty("price")
    public String getPrice() {
        return price;
    }
    @JsonProperty("price")
    public void setPrice(String price) {
        this.price = price;
    }

    @JsonProperty("arrival")
    public void setArrival(Arrival arrival) {
        this.arrival = arrival;
    }

    @JsonProperty("arrival_time")
    public String getArrivalTime() {
        return arrivalTime;
    }

    @JsonProperty("arrival_time")
    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @JsonProperty("departure")
    public Departure getDeparture() {
        return departure;
    }

    @JsonProperty("departure")
    public void setDeparture(Departure departure) {
        this.departure = departure;
    }

    @JsonProperty("departure_time")
    public String getDepartureTime() {
        return departureTime;
    }

    @JsonProperty("departure_time")
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    @JsonProperty("airline")
    public Airline getAirline() {
        return airline;
    }

    @JsonProperty("airline")
    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}