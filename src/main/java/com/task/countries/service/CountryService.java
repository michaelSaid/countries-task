package com.task.countries.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.countries.model.Country;
import com.task.countries.repository.CountryRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
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
