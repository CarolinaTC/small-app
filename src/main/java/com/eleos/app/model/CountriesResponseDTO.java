package com.eleos.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

public class CountriesResponseDTO {

	private List<CountryDTO> countries;
	private Integer currentPage;
	private Long totalItems;
	private Integer totalPages;

	public CountriesResponseDTO() {
	}

	public CountriesResponseDTO(List<CountryDTO> countries, Integer currentPage, Long totalItems, Integer totalPages) {
		this.countries = countries;
		this.currentPage = currentPage;
		this.totalItems = totalItems;
		this.totalPages = totalPages;
	}
	public List<CountryDTO> getCountries() {
		return countries;
	}

	public void setCountries(List<CountryDTO> countries) {
		this.countries = countries;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Long getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(Long totalItems) {
		this.totalItems = totalItems;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}


}