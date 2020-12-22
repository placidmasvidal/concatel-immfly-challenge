package com.immfly.immflychallenge.services.clients;

import java.util.List;

import com.immfly.immflychallenge.dtos.FlightDto;

public interface IFlightsClient {

	List<FlightDto> getFlights();
	
}
