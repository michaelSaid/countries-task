package com.task.countries.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DataModel {
    @JsonProperty("error")
    private Boolean error;
    @JsonProperty("msg")
    private String msg;
    @JsonProperty("data")
    private List<Country> data = new ArrayList<>();

    @Data
    public static class Country {
        @JsonProperty("country")
        private String country;
        @JsonProperty("code")
        private String code;
        @JsonProperty("iso3")
        private String iso3;
        @JsonProperty("populationCounts")
        private List<PopulationCount> populationCountList = new ArrayList<>();
    }

    @Data
    public static class PopulationCount {
        @JsonProperty("year")
        private String year;
        @JsonProperty("value")
        private String value;
    }
}
