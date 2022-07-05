package com.example.examenp1.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.examenp1.demo.model.Airport;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long>{

}
