package com.task.countries.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.task.countries.model.Country;
import com.task.countries.model.DataModel;
import com.task.countries.service.CountryService;

@RestController
@RequestMapping("/country")
public class CountryController {

    private static final Logger logger = LogManager.getLogger(CountryController.class);

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private CountryService countryService;

    @GetMapping("")
    public List<Country> list(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "50") int size) {
        Pageable paging = PageRequest.of(page, size);
        return countryService.listAllCountry(paging).getContent();
    }

    @GetMapping("/{name}")
    public ResponseEntity<Country> getPopulations(@PathVariable String name) {
        try {
            Country country = countryService.getCountry(name);
            return new ResponseEntity<>(country, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/sync")
    public void sync() {
        ResponseEntity<DataModel> response = restTemplate.getForEntity("https://countriesnow.space/api/v0.1/countries/population", DataModel.class);

        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            List<Country> countries = response.getBody().getData().stream().map(CountryController::convertDataModelCountryToCountry).toList();
            countryService.saveAll(countries);
        }
    }

    private static Country convertDataModelCountryToCountry(DataModel.Country country) {
        return new Country(country.getCountry(), country.getCode(), country.getIso3(), country.getPopulationCountList());
    }
}
