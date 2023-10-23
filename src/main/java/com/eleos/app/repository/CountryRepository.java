package com.eleos.app.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.eleos.app.db.Country;

public interface CountryRepository extends CrudRepository<Country, Integer > {
	
}