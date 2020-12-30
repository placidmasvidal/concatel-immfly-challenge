package com.ryanair.flight.services;

import java.io.IOException;
import java.util.List;

import com.ryanair.flight.dtos.RyanairFlightDto;

public interface IFlightProviderService {

	List<RyanairFlightDto> retrieveFlights() throws IOException;

}
