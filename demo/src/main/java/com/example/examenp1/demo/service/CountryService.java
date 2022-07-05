package com.example.examenp1.demo.service;

import java.util.List;

import com.example.examenp1.demo.model.Country;

public interface CountryService {

	Country updateCountry(Country country);
	
	List<Country> getAllCountry();

	Country getCountryById(long countryId);

	void deleteCountry(long id);
}