package com.immfly.immflychallenge.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.immfly.immflychallenge.entities.Flight;
import com.immfly.immflychallenge.exceptions.FlightException;
import com.immfly.immflychallenge.generic.CustomRepository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, String>, CustomRepository{
		Optional<Flight> findByFlightId (String flightId) throws FlightException;
}