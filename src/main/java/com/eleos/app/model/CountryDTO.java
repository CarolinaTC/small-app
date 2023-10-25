package com.eleos.app.model;

/**
 * Data Transfer Object (DTO) for representing country data.
 */
public class CountryDTO {
	    
    private String name;
    
	public CountryDTO() {
	}

	/**
	 * Constructs a CountryDTO with the provided country name.
	 *
	 * @param name The name of the country.
	 */
	public CountryDTO(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
