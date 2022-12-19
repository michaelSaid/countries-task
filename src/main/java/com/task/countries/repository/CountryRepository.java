package com.task.countries.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.countries.model.Country;

public interface CountryRepository extends JpaRepository<Country, String> {
}
