package com.immfly.immflychallenge.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.immfly.immflychallenge.entities.Flight;
import com.immfly.immflychallenge.exceptions.FlightException;

public interface FlightJpaRepository extends JpaRepository<Flight, String>, FlightCustomJpaRepository {
	
	Optional<Flight> findByFlightId (String flightId) throws FlightException;
	
}
