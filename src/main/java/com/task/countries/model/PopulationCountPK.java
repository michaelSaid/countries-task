package com.task.countries.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class PopulationCountPK implements Serializable {
    @Column(name = "code")
    private String code;
    @Column(name = "year")
    private String year;
}
