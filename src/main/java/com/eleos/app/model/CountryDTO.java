package com.eleos.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;

@Data
public class CountryDTO {
	    
    private String name;
    
	public CountryDTO() {
	

	}

	public CountryDTO(String name) {
		this.name = name;

	}

	public String getName() {
		return name;
	}
	

}
