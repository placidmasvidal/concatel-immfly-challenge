package com.immfly.immflychallenge.services;

import com.immfly.immflychallenge.dtos.FlightDto;
import com.immfly.immflychallenge.exceptions.FlightException;

public interface IFlightService {

	FlightDto getFlightByTailNumber(String tailNumber, String flightId)	throws FlightException;
	
}
