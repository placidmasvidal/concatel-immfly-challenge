package com.immfly.immflychallenge.services;

import com.immfly.immflychallenge.dtos.FlightDto;
import com.immfly.immflychallenge.exceptions.FlightException;

public interface IFlightService {

	FlightDto getFlightByTailNumber(Long tailNumber, Long flightId)	throws FlightException;
	
}
