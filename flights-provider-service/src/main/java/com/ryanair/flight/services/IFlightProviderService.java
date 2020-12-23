package com.ryanair.flight.services;

import java.io.IOException;
import java.util.List;

import com.ryanair.flight.dtos.FlightDto;

public interface IFlightProviderService {

	List<FlightDto> retrieveFlights() throws IOException;

}
