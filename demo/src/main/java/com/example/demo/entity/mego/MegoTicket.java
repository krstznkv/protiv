package com.example.demo.entity.mego;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "billingPrice",
        "departureDate",
        "departureDateLocal",
        "departureDestinationUID",
        "arrivalDate",
        "arrivalDateLocal",
        "arrivalDestinationUID",
        "departureTerminal",
        "arrivalTerminal",
        "flightCode",
        "airlineUID",
        "operatingAirlineUID",
        "aircraftUID",
        "departure_air",
        "arrival_air"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class MegoTicket {
    @JsonProperty("airline")
    private String airline;
    @JsonProperty("billingPrice")
    private String billingPrice;
    @JsonProperty("departureDate")
    private String departureDate;
    @JsonProperty("departureDateLocal")
    private String departureDateLocal;
    @JsonProperty("departureDestinationUID")
    private String departureDestinationUID;
    @JsonProperty("arrivalDate")
    private String arrivalDate;
    @JsonProperty("arrivalDateLocal")
    private String arrivalDateLocal;
    @JsonProperty("arrivalDestinationUID")
    private String arrivalDestinationUID;
    @JsonProperty("departureTerminal")
    private Object departureTerminal;
    @JsonProperty("arrivalTerminal")
    private Object arrivalTerminal;
    @JsonProperty("flightCode")
    private String flightCode;
    @JsonProperty("airlineUID")
    private String airlineUID;
    @JsonProperty("operatingAirlineUID")
    private String operatingAirlineUID;
    @JsonProperty("aircraftUID")
    private String aircraftUID;
    @JsonProperty("departure_air")
    private String departureAir;
    @JsonProperty("arrival_air")
    private String arrivalAir;
   // @JsonIgnore
   // private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("billingPrice")
    public String getBillingPrice() {
        return billingPrice;
    }

    @JsonProperty("billingPrice")
    public void setBillingPrice(String billingPrice) {
        this.billingPrice = billingPrice;
    }

    @JsonProperty("departureDate")
    public String getDepartureDate() {
        return departureDate;
    }

    @JsonProperty("departureDate")
    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    @JsonProperty("departureDateLocal")
    public String getDepartureDateLocal() {
        return departureDateLocal;
    }

    @JsonProperty("departureDateLocal")
    public void setDepartureDateLocal(String departureDateLocal) {
        this.departureDateLocal = departureDateLocal;
    }

    @JsonProperty("departureDestinationUID")
    public String getDepartureDestinationUID() {
        return departureDestinationUID;
    }

    @JsonProperty("departureDestinationUID")
    public void setDepartureDestinationUID(String departureDestinationUID) {
        this.departureDestinationUID = departureDestinationUID;
    }

    @JsonProperty("arrivalDate")
    public String getArrivalDate() {
        return arrivalDate;
    }

    @JsonProperty("arrivalDate")
    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    @JsonProperty("arrivalDateLocal")
    public String getArrivalDateLocal() {
        return arrivalDateLocal;
    }

    @JsonProperty("arrivalDateLocal")
    public void setArrivalDateLocal(String arrivalDateLocal) {
        this.arrivalDateLocal = arrivalDateLocal;
    }

    @JsonProperty("arrivalDestinationUID")
    public String getArrivalDestinationUID() {
        return arrivalDestinationUID;
    }

    @JsonProperty("arrivalDestinationUID")
    public void setArrivalDestinationUID(String arrivalDestinationUID) {
        this.arrivalDestinationUID = arrivalDestinationUID;
    }

    @JsonProperty("departureTerminal")
    public Object getDepartureTerminal() {
        return departureTerminal;
    }

    @JsonProperty("departureTerminal")
    public void setDepartureTerminal(Object departureTerminal) {
        this.departureTerminal = departureTerminal;
    }

    @JsonProperty("arrivalTerminal")
    public Object getArrivalTerminal() {
        return arrivalTerminal;
    }

    @JsonProperty("arrivalTerminal")
    public void setArrivalTerminal(Object arrivalTerminal) {
        this.arrivalTerminal = arrivalTerminal;
    }

    @JsonProperty("flightCode")
    public String getFlightCode() {
        return flightCode;
    }

    @JsonProperty("flightCode")
    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    @JsonProperty("airlineUID")
    public String getAirlineUID() {
        return airlineUID;
    }

    @JsonProperty("airlineUID")
    public void setAirlineUID(String airlineUID) {
        this.airlineUID = airlineUID;
    }

    @JsonProperty("operatingAirlineUID")
    public String getOperatingAirlineUID() {
        return operatingAirlineUID;
    }

    @JsonProperty("operatingAirlineUID")
    public void setOperatingAirlineUID(String operatingAirlineUID) {
        this.operatingAirlineUID = operatingAirlineUID;
    }

    @JsonProperty("aircraftUID")
    public String getAircraftUID() {
        return aircraftUID;
    }

    @JsonProperty("aircraftUID")
    public void setAircraftUID(String aircraftUID) {
        this.aircraftUID = aircraftUID;
    }

    @JsonProperty("departure_air")
    public String getDepartureAir() {
        return departureAir;
    }
    @JsonProperty("airline")
    public String getAirline() {
        return airline;
    }
    @JsonProperty("airline")
    public void setAirline(String aircraft) {
        this.airline = aircraft;
    }

    @JsonProperty("departure_air")
    public void setDepartureAir(String departureAir) {
        this.departureAir = departureAir;
    }

    @JsonProperty("arrival_air")
    public String getArrivalAir() {
        return arrivalAir;
    }

    @JsonProperty("arrival_air")
    public void setArrivalAir(String arrivalAir) {
        this.arrivalAir = arrivalAir;
    }

   /* @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }*/

}
