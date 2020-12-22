package com.immfly.immflychallenge.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.immfly.immflychallenge.dtos.FlightDto;
import com.immfly.immflychallenge.exceptions.FlightException;
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
	public FlightDto getFlightByTailNumber(String tailNumber, String flightId) throws FlightException{
		
		Optional<FlightDto> flight = checkForFlightsProcess().stream()
							.filter(x -> x.getIdent().equals(flightId))
							.findFirst();
		if(!flight.isPresent()) {
			throw new FlightException("Couldn't find flight with flight id = " + flightId);
		}
		
		return flight.get();	
	}


	@Scheduled(cron = "0 * * * * ?")
	private List<FlightDto> checkForFlightsProcess() {
		return flightsClient.getFlights();
	}
	
}
