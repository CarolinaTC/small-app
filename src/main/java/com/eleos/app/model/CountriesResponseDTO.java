package com.eleos.app.model;

import java.util.List;
/**
 * Data Transfer Object (DTO) for representing a list of countries and pagination information.
 */
public class CountriesResponseDTO {

	private List<CountryDTO> countries;
	private Integer currentPage;
	private Long totalItems;
	private Integer totalPages;

	public CountriesResponseDTO() {
	}
	/**
	 * Constructs a CountriesResponseDTO with the provided data.
	 *
	 * @param countries  List of CountryDTO objects representing countries.
	 * @param currentPage The current page number.
	 * @param totalItems  The total number of items across all pages.
	 * @param totalPages  The total number of pages.
	 */
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
