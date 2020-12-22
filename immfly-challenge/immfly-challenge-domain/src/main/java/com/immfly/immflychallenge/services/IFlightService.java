package com.immfly.immflychallenge.services;

import java.util.Optional;

import com.immfly.immflychallenge.entities.Flight;
import com.immfly.immflychallenge.exceptions.FlightException;

public interface IFlightService {
	Optional<Flight> findByFlightId (Long flightId) throws FlightException;
}
