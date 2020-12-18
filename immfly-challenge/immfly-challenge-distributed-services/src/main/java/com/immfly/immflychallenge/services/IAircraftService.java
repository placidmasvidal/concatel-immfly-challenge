package com.immfly.immflychallenge.services;

import java.util.List;

public interface IAircraftService {
	List<FlightDto> getFlightsByAircraftId(Long aircraftId) throws AircraftException;
}
