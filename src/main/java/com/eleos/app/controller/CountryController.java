package com.eleos.app.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eleos.app.db.Country;
import com.eleos.app.exception.CountryNotFoundException;
import com.eleos.app.model.CountryDTO;
import com.eleos.app.service.CountryService;

@RestController
@RequestMapping("/api")
public class CountryController {
	
	private CountryService countryService;
	
	public CountryController (CountryService countryService) {
		this.countryService = countryService;
	}
	
	// endpoint 1
	@PostMapping("/countries")
	
	public ResponseEntity createCountry (@RequestBody CountryDTO countryDTO) {
		countryService.createCountry(countryDTO);
		return ResponseEntity.ok().build();
	}
	
	// endpoint 2
	//@GetMapping("/countries") 
		
	//public ResponseEntity<List<Country>> getCountries() {
	//	return new ResponseEntity<>(countryService.getCountries(), HttpStatus.OK);
	//}
    @GetMapping("/countries")
    public ResponseEntity<List<CountryDTO>> getCountries() {
        return new ResponseEntity<>(countryService.getCountries(), HttpStatus.OK);
    }
	// endpoint 3
	@GetMapping("/country/{id}")
	
	public ResponseEntity<Country> getCountryById(@PathVariable(required = false) Integer id) {
		try {
			new ResponseEntity<>(countryService.getCountryById(id), HttpStatus.OK);
			return ResponseEntity.ok().build();
		} catch (CountryNotFoundException e) {
			return	ResponseEntity.notFound().build();
		}

	}
	
	// endpoint 4
	@PutMapping("/country/{id}")
	
	public ResponseEntity updateCountryName(@PathVariable(required = false) Integer id, @RequestBody CountryDTO countryDTO) {
		try {
			countryService.updateCountryName(id, countryDTO);
			return ResponseEntity.ok().build();
		} catch (CountryNotFoundException e) {
			return	ResponseEntity.notFound().build();
		}
		
		
		
	}
	
	
	// endpoint 5
	@DeleteMapping("/country/{id}")
	
	public ResponseEntity deleteCountry(@PathVariable(required = false) Integer id) {
		try {
			countryService.deleteCountry(id);
			return ResponseEntity.ok().build();
		} catch (CountryNotFoundException e) {
		return	ResponseEntity.notFound().build();
		}
		
	}
	
	
	
	
}
