package com.task.countries.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class PopulationCountPK implements Serializable {
    @Column(name = "name")
    private String name;
    @Column(name = "year")
    private String year;

    public PopulationCountPK(String name, String year) {
        this.name = name;
        this.year = year;
    }
    public PopulationCountPK() {
    }
    @Override
    public String toString() {
        return "PopulationCountPK{" +
            "name='" + name + '\'' +
            ", year='" + year + '\'' +
            '}';
    }

    public String getYear() {
        return year;
    }
}
