package com.eleos.app.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Country {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false, unique = true)
    private String name;
    
    
    public Country() {
  
    }
    
	public Country (String name) {
		this.name = name;
	}
	

	public String setName(String name) {
		return name;
	}
	
	public String getName() {
		return name;
	}


}
