package com.task.countries.controller;

import java.util.List;
import java.util.NoSuchElementException;

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

import com.task.countries.model.Country;
import com.task.countries.service.CountryService;

@RestController
@RequestMapping("/country")
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping("")
    public List<Country> list(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "50") int size) {
        Pageable paging = PageRequest.of(page, size);
        return countryService.listAllCountry(paging).getContent();
    }

    @GetMapping("/{name}")
    public ResponseEntity<Country> get(@PathVariable String name) {
        try {
            Country country = countryService.getCountry(name);
            return new ResponseEntity<>(country, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//    @GetMapping("/sync")
//    public ResponseEntity<Country> get(@PathVariable String name) {
//        try {
//            Country country = countryService.getCountry(name);
//            return new ResponseEntity<>(country, HttpStatus.OK);
//        } catch (NoSuchElementException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
}
