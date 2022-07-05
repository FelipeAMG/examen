package com.example.examenp1.demo.service;

import java.util.List;

import com.example.examenp1.demo.model.Airport;

public interface AirportService {

	Airport updateAirport(Airport airport);
	
	List<Airport> getAllAirport();

	Airport getAirportById(long airportId);

	void deleteAirport(long id);
}