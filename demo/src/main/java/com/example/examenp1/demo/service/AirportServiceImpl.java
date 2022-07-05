package com.example.examenp1.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.examenp1.demo.exception.ResourceNotFoundException;
import com.example.examenp1.demo.model.Airport;
import com.example.examenp1.demo.repositories.AirportRepository;

@Service
@Transactional
public class AirportServiceImpl implements AirportService{

	@Autowired
	AirportRepository airportRepository;

	@Override
	public Airport updateAirport(Airport airport) {
		Optional<Airport> airportDb = this.airportRepository.findById(airport.getId());

		if (airportDb.isPresent()) {
			Airport airportUpdate = airportDb.get();
			airportUpdate.setId(airport.getId());
			airportUpdate.setName(airport.getName());

			return airportUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + airport.getId());
		}
	}

	@Override
	public List<Airport> getAllAirport() {
		return this.airportRepository.findAll();
	}

	@Override
	public Airport getAirportById(long airportId) {
		Optional<Airport> airportDb = this.airportRepository.findById(airportId);

		if (airportDb.isPresent()) {
			return airportDb.get();
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + airportId);
		}
	}

	@Override
	public void deleteAirport(long airportId) {
		Optional<Airport> airportDb = this.airportRepository.findById(airportId);

		if (airportDb.isPresent()) {
			this.airportRepository.delete(airportDb.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + airportId);
		}
	}
}
