package com.eleos.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
/**
 * Data Transfer Object (DTO) for representing country data.
 */
@Data
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
	

}
