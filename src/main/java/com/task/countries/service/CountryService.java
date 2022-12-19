package com.task.countries.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<Country> listAllCountry(Pageable pageable) {
        return countryRepository.findAll(pageable);
    }

    public void saveCountry(Country country) {
        countryRepository.save(country);
    }

    public void saveAll(List<Country> countries) {
        countryRepository.saveAll(countries);
    }

    public Country getCountry(String name) {
        return countryRepository.findById(name).orElse(null);
    }
}
