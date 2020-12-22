package com.immfly.immflychallenge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.immfly.immflychallenge.dtos.FlightDto;
import com.immfly.immflychallenge.exceptions.FlightException;
import com.immfly.immflychallenge.generic.GenericRepository;
import com.immfly.immflychallenge.mappers.IFlightMapper;
import com.immfly.immflychallenge.repositories.FlightRepository;

@Service
public class FlightServiceImpl implements IFlightService {

	private final FlightRepository flightRepository;
	private GenericRepository genericRepository;
	private IFlightMapper flightMapper;
	
	@Autowired
	public FlightServiceImpl(FlightRepository flightRepository,
			GenericRepository genericRepository) {
		this.flightRepository = flightRepository;
		this.genericRepository = genericRepository;
	}


	@Override
	public FlightDto getFlightByTailNumber(Long tailNumber, Long flightId) throws FlightException{
		return null;	//FIXME
	}
	
}
