package com.task.countries.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "countries")
public class Country {
    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;
    private String iso3;

    @OneToMany(mappedBy="country", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<PopulationCount> populationCountList;

    public Country() {
        populationCountList = new ArrayList<>();
    }

    public Country(String name, String code, String iso3, List<DataModel.PopulationCount> populationCountList) {
        this.name = name;
        this.code = code;
        this.iso3 = iso3;
        this.populationCountList = populationCountList.stream().map(populationCount -> new PopulationCount(this, populationCount.getYear(), populationCount.getValue())).toList();
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIso3() {
        return iso3;
    }

    public void setIso3(String iso3) {
        this.iso3 = iso3;
    }

    public List<PopulationCount> getPopulationCountList() {
        return populationCountList;
    }

    @Override
    public String toString() {
        return "Country{" +
            "name='" + name + '\'' +
            ", code='" + code + '\'' +
            ", iso3='" + iso3 + '\'' +
            ", populationCountList=" + populationCountList +
            '}';
    }
}
