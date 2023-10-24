package com.eleos.app.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.eleos.app.db.Country;
import com.eleos.app.exception.CountryNotFoundException;
import com.eleos.app.model.CountryDTO;
import com.eleos.app.repository.CountryRepository;

@Service
public class CountryService {
	
	private CountryRepository countryRepository;
	
	public CountryService (CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}
	
	
	public void createCountry (CountryDTO countryDTO) {
		//TODO: check if country exists
		//TODO: if so, throw exception
		
		Country country = new Country(countryDTO.getName());
		countryRepository.save(country);
	}
	
	public List<CountryDTO> getCountries() {
		//TODO: pagination
		List<Country> countries = new ArrayList<Country>();
		countryRepository.findAll().iterator().forEachRemaining(countries::add);
		
        List<CountryDTO> countryDTOs = countries
                .stream()
                .map(country -> new CountryDTO(country.getName()))
                .sorted(Comparator.comparing(CountryDTO::getName))
                .collect(Collectors.toList());
		return countryDTOs;
	}
	
	public Country getCountryById(Integer id) throws CountryNotFoundException  {

		if (countryRepository.findById(id).isPresent()) {
			return countryRepository.findById(id).get();

		} else {
			throw new CountryNotFoundException();
		}

	}
	
	public void updateCountryName(Integer id, CountryDTO countryDTO) throws CountryNotFoundException {
		   if (countryRepository.findById(id).isPresent()) {
		        Country country = countryRepository.findById(id).get();
		        country.setName(countryDTO.getName());
		        countryRepository.save(country);
		    } else {
		        throw new CountryNotFoundException();
		    }
		

	}
	
	public void deleteCountry(Integer id) throws CountryNotFoundException {
	
		if (countryRepository.findById(id).isPresent()) {
			countryRepository.deleteById(id);
		}
		else {
			throw new CountryNotFoundException();
		}
		
	}
}
