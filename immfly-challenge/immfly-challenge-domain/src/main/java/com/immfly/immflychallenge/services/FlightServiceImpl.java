package com.immfly.immflychallenge.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.immfly.immflychallenge.entities.Flight;
import com.immfly.immflychallenge.exceptions.FlightException;
import com.immfly.immflychallenge.generic.GenericRepository;
import com.immfly.immflychallenge.repositories.FlightRepository;

@Service
public class FlightServiceImpl implements IFlightService {

	private final FlightRepository flightRepository;
	private GenericRepository genericRepository;
	
	@Autowired
	public FlightServiceImpl(FlightRepository flightRepository,
			GenericRepository genericRepository) {
		this.flightRepository = flightRepository;
		this.genericRepository = genericRepository;
	}

	@Override
	public Optional<Flight> findByFlightId(Long flightId) throws FlightException {
		Optional<Flight> result = flightRepository.findByFlightId(flightId);
		if(!result.isPresent()) {
			throw new FlightException("Flight could not be found with flight id = " + flightId);
		}
		
		return result;
	}


}
