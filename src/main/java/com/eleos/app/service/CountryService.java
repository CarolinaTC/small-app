package com.eleos.app.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.eleos.app.exception.CountryAlreadyExist;
import com.eleos.app.model.CountriesResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

	/**
	 * Create a new country if it doesn't already exist.
	 *
	 * @param countryDTO JSON object containing the country's name.
	 * @throws CountryAlreadyExist if the country already exists.
	 */
	public void createCountry (CountryDTO countryDTO) throws CountryAlreadyExist {
		if (countryRepository.existsByName(countryDTO.getName())){
			throw new CountryAlreadyExist();
		} else {
			Country country = new Country(countryDTO.getName());
			countryRepository.save(country);
		}
	}

	/**
	 * Get a paginated list of countries sorted alphabetically by name.
	 *
	 * @param pageNumber Page number for pagination.
	 * @return CountriesResponseDTO containing a list of countries and pagination information.
	 */
	public CountriesResponseDTO getCountries(Integer pageNumber) {
		Pageable paging = PageRequest.of(pageNumber, 5);
		Page<Country> page = countryRepository.findAll(paging);

		List<Country> countries = new ArrayList<>();
		page.forEach(countries::add);
		List<CountryDTO> countryDTOs = countries
				.stream()
				.map(country -> new CountryDTO(country.getName()))
				.sorted(Comparator.comparing(CountryDTO::getName))
				.collect(Collectors.toList());

		CountriesResponseDTO response =
				new CountriesResponseDTO(countryDTOs, page.getNumber(),
						page.getTotalElements(), page.getTotalPages());
		return response;
	}

	/**
	 * Get a country by its unique ID.
	 *
	 * @param id The unique ID of the country.
	 * @return The requested country.
	 * @throws CountryNotFoundException if the country is not found.
	 */
	public CountryDTO getCountryById(Integer id) throws CountryNotFoundException  {
		if (countryRepository.findById(id).isPresent()) {
			return new CountryDTO(countryRepository.findById(id).get().getName());
		} else {
			throw new CountryNotFoundException();
		}
	}

	/**
	 * Update a country's name by its unique ID.
	 *
	 * @param id  The unique ID of the country to be updated.
	 * @param countryDTO JSON object containing the new country name.
	 * @throws CountryNotFoundException if the country is not found.
	 */
	public void updateCountryName(Integer id, CountryDTO countryDTO) throws CountryNotFoundException {
	   if (countryRepository.findById(id).isPresent()) {
	        Country country = countryRepository.findById(id).get();
	        country.setName(countryDTO.getName());
	        countryRepository.save(country);
	    } else {
	        throw new CountryNotFoundException();
	    }
	}
	/**
	 * Delete a country by its unique ID.
	 *
	 * @param id The unique ID of the country to be deleted.
	 * @throws CountryNotFoundException if the country is not found.
	 */
	public void deleteCountry(Integer id) throws CountryNotFoundException {
	
		if (countryRepository.findById(id).isPresent()) {
			countryRepository.deleteById(id);
		}
		else {
			throw new CountryNotFoundException();
		}
	}
}
