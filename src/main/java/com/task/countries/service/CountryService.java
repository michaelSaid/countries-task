package com.task.countries.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.task.countries.model.Country;
import com.task.countries.repository.CountryRepository;

public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    public List<Country> listAllCountry() {
        return countryRepository.findAll();
    }

    public void saveCountry(Country country) {
        countryRepository.save(country);
    }

    public Country getCountry(String name) {
        return countryRepository.findById(name).orElse(null);
    }
}
