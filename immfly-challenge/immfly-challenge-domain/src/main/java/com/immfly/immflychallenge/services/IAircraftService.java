package com.immfly.immflychallenge.services;

import java.util.List;

import com.immfly.immflychallenge.dtos.FlightDto;
import com.immfly.immflychallenge.exceptions.AircraftException;

public interface IAircraftService {
	List<FlightDto> getFlightsByAircraftId(Long aircraftId) throws AircraftException;
}
