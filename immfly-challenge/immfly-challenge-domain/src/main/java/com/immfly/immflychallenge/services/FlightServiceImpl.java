package com.immfly.immflychallenge.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.immfly.immflychallenge.dtos.FlightDto;
import com.immfly.immflychallenge.exceptions.FlightException;
import com.immfly.immflychallenge.generic.GenericRepository;
import com.immfly.immflychallenge.mappers.IFlightMapper;
import com.immfly.immflychallenge.repositories.FlightRepository;
import com.immfly.immflychallenge.services.clients.IFlightsClient;

@Service
public class FlightServiceImpl implements IFlightService {

	private IFlightsClient flightsClient;
	
	@Autowired
	public FlightServiceImpl(IFlightsClient flightsClient) {
		this.flightsClient = flightsClient;
	}


	//TODO
	@Override
	public FlightDto getFlightByTailNumber(Long tailNumber, Long flightId) throws FlightException{
		return null;	
	}


	@Scheduled(cron = "0 * * * * ?")
	private List<FlightDto> checkForFlightsProcess() {
		return flightsClient.getFlights();
	}
	
}
