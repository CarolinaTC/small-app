package com.eleos.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.eleos.app.db.Country;

public interface CountryRepository extends JpaRepository<Country, Integer > {
	



}