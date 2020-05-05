package com.example.demo.entity;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "from",
        "to",
        "date",
        "children",
        "adult",
        "ret_date"
})
public class Request {

    @JsonProperty("from")
    private String from;
    @JsonProperty("to")
    private String to;
    @JsonProperty("date")
    private String date;
    @JsonProperty("children")
    private Integer children;
    @JsonProperty("adult")
    private Integer adult;
    @JsonProperty("ret_date")
    private String retDate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("from")
    public String getFrom() {
        return from;
    }

    @JsonProperty("from")
    public void setFrom(String from) {
        this.from = from;
    }

    @JsonProperty("to")
    public String getTo() {
        return to;
    }

    @JsonProperty("to")
    public void setTo(String to) {
        this.to = to;
    }

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("children")
    public Integer getChildren() {
        return children;
    }

    @JsonProperty("children")
    public void setChildren(Integer children) {
        this.children = children;
    }

    @JsonProperty("adult")
    public Integer getAdult() {
        return adult;
    }

    @JsonProperty("adult")
    public void setAdult(Integer adult) {
        this.adult = adult;
    }

    @JsonProperty("ret_date")
    public String getRetDate() {
        return retDate;
    }

    @JsonProperty("ret_date")
    public void setRetDate(String retDate) {
        this.retDate = retDate;
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