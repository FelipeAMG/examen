package com.example.examenp1.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.examenp1.demo.exception.ResourceNotFoundException;
import com.example.examenp1.demo.model.Country;
import com.example.examenp1.demo.repositories.CountryRepository;

@Service
@Transactional
public class CountryServiceImpl implements CountryService{

	@Autowired
	CountryRepository countryRepository;

	@Override
	public Country updateCountry(Country country) {
		Optional<Country> countryDb = this.countryRepository.findById(country.getId());

		if (countryDb.isPresent()) {
			Country countryUpdate = countryDb.get();
			countryUpdate.setId(country.getId());
			countryUpdate.setName(country.getName());

			return countryUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + country.getId());
		}
	}

	@Override
	public List<Country> getAllCountry() {
		return this.countryRepository.findAll();
	}

	@Override
	public Country getCountryById(long countryId) {
		Optional<Country> countryDb = this.countryRepository.findById(countryId);

		if (countryDb.isPresent()) {
			return countryDb.get();
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + countryId);
		}
	}

	@Override
	public void deleteCountry(long countryId) {
		Optional<Country> countryDb = this.countryRepository.findById(countryId);

		if (countryDb.isPresent()) {
			this.countryRepository.delete(countryDb.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + countryId);
		}
	}
}
