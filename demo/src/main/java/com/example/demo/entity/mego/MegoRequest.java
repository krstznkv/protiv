package com.example.demo.entity.mego;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "locale",
        "theme",
        "sections",
        "adults",
        "children",
        "babies",
        "bookingClass",
        "isRangeSearch",
        "partnerCookie",
        "appId",
        "appSecret"
})
public class MegoRequest {

    @JsonProperty("locale")
    private String locale;
    @JsonProperty("theme")
    private String theme;
    @JsonProperty("sections")
    private List<Section> sections = null;
    @JsonProperty("adults")
    private Integer adults;
    @JsonProperty("children")
    private Integer children;
    @JsonProperty("babies")
    private Integer babies;
    @JsonProperty("bookingClass")
    private String bookingClass;
    @JsonProperty("isRangeSearch")
    private Boolean isRangeSearch;
    @JsonProperty("partnerCookie")
    private String partnerCookie;
    @JsonProperty("appId")
    private String appId;
    @JsonProperty("appSecret")
    private String appSecret;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("locale")
    public String getLocale() {
        return locale;
    }

    @JsonProperty("locale")
    public void setLocale(String locale) {
        this.locale = locale;
    }

    @JsonProperty("theme")
    public String getTheme() {
        return theme;
    }

    @JsonProperty("theme")
    public void setTheme(String theme) {
        this.theme = theme;
    }

    @JsonProperty("sections")
    public List<Section> getSections() {
        return sections;
    }

    @JsonProperty("sections")
    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    @JsonProperty("adults")
    public Integer getAdults() {
        return adults;
    }

    @JsonProperty("adults")
    public void setAdults(Integer adults) {
        this.adults = adults;
    }

    @JsonProperty("children")
    public Integer getChildren() {
        return children;
    }

    @JsonProperty("children")
    public void setChildren(Integer children) {
        this.children = children;
    }

    @JsonProperty("babies")
    public Integer getBabies() {
        return babies;
    }

    @JsonProperty("babies")
    public void setBabies(Integer babies) {
        this.babies = babies;
    }

    @JsonProperty("bookingClass")
    public String getBookingClass() {
        return bookingClass;
    }

    @JsonProperty("bookingClass")
    public void setBookingClass(String bookingClass) {
        this.bookingClass = bookingClass;
    }

    @JsonProperty("isRangeSearch")
    public Boolean getIsRangeSearch() {
        return isRangeSearch;
    }

    @JsonProperty("isRangeSearch")
    public void setIsRangeSearch(Boolean isRangeSearch) {
        this.isRangeSearch = isRangeSearch;
    }

    @JsonProperty("partnerCookie")
    public String getPartnerCookie() {
        return partnerCookie;
    }

    @JsonProperty("partnerCookie")
    public void setPartnerCookie(String partnerCookie) {
        this.partnerCookie = partnerCookie;
    }

    @JsonProperty("appId")
    public String getAppId() {
        return appId;
    }

    @JsonProperty("appId")
    public void setAppId(String appId) {
        this.appId = appId;
    }

    @JsonProperty("appSecret")
    public String getAppSecret() {
        return appSecret;
    }

    @JsonProperty("appSecret")
    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "from",
            "to",
            "date"
    })
    public static class Section {

        @JsonProperty("from")
        private String from;
        @JsonProperty("to")
        private String to;
        @JsonProperty("date")
        private String date;
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

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

}