package com.eleos.app.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.eleos.app.exception.CountryAlreadyExist;
import com.eleos.app.model.CountriesResponseDTO;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
	/**
	 * Create a new country.
	 *
	 * @param countryDTO JSON object containing the country's name.
	 * @return ResponseEntity with HTTP status OK if successful, or NOT_FOUND if the country already exists.
	 */
	@PostMapping("/countries")
	public ResponseEntity createCountry (@RequestBody CountryDTO countryDTO) {
		try {
			countryService.createCountry(countryDTO);
			return ResponseEntity.ok().build();
		} catch (CountryAlreadyExist e) {
			return	ResponseEntity.notFound().build();
		}
	}
	
	// endpoint 2
	/**
	 * Get a paginated list of all countries sorted alphabetically by name.
	 *
	 * @param page Page number for pagination.
	 * @return ResponseEntity containing a list of countries and HTTP status OK.
	 */
    @GetMapping("/countries")
    public ResponseEntity<CountriesResponseDTO> getCountries(@RequestParam(defaultValue = "0") int page) {
        return new ResponseEntity<>(countryService.getCountries(page), HttpStatus.OK);
    }
	// endpoint 3
	/**
	 * Get a country by its unique ID.
	 *
	 * @param id The unique ID of the country.
	 * @return ResponseEntity containing the country and HTTP status OK if found, or NOT_FOUND if not found.
	 */
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
	/**
	 * Update a country's name by its unique ID.
	 *
	 * @param id         The unique ID of the country to be updated.
	 * @param countryDTO JSON object containing the new country name.
	 * @return ResponseEntity with HTTP status OK if successful, or NOT_FOUND if the country is not found.
	 */
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
	/**
	 * Delete a country by its unique ID.
	 *
	 * @param id The unique ID of the country to be deleted.
	 * @return ResponseEntity with HTTP status OK if successful, or NOT_FOUND if the country is not found.
	 */
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
