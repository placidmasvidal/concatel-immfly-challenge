package com.immfly.immflychallenge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.immfly.immflychallenge.repositories.FlightRepository;

@Service
public class FlightService implements IFlightService {

	private final FlightRepository flightRepository;
	
	@Autowired
	public FlightService(FlightRepository flightRepository) {
		this.flightRepository = flightRepository;
	}


}
