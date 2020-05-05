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
        "id",
        "oak",
        "name",
        "oak_name"
})
public class Airline {

    @JsonProperty("id")
    private String id;
    @JsonProperty("oak")
    private String oak;
    @JsonProperty("name")
    private String name;
    @JsonProperty("oak_name")
    private String oakName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("oak")
    public String getOak() {
        return oak;
    }

    @JsonProperty("oak")
    public void setOak(String oak) {
        this.oak = oak;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("oak_name")
    public String getOakName() {
        return oakName;
    }

    @JsonProperty("oak_name")
    public void setOakName(String oakName) {
        this.oakName = oakName;
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