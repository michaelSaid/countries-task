package com.task.countries.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "populations")
public class PopulationCount {
    @EmbeddedId
    private PopulationCountPK populationCountPK;
    private String value;

    @ManyToOne
    @MapsId("code")
    private Country country;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
