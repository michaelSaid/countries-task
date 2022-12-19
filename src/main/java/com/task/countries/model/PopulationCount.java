package com.task.countries.model;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "populations")
public class PopulationCount {
    @EmbeddedId
    private PopulationCountPK populationCountPK;
    private String value;

    public PopulationCount() {
    }

    public PopulationCount(Country country, String year, String value) {
        this.populationCountPK = new PopulationCountPK(country.getName(), year);
        this.value = value;
        this.country = country;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @MapsId("name")
    private Country country;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getYear() {
        return populationCountPK.getYear();
    }

    @Override
    public String toString() {
        return "PopulationCount{" +
            "populationCountPK=" + populationCountPK +
            ", value='" + value + '\'' +
            ", country=" + country +
            '}';
    }
}
