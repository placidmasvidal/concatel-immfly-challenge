package com.ryanair.flight.controllers;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ryanair.flight.dtos.RyanairFlightDto;
import com.ryanair.flight.dtos.GenericResponse;
import com.ryanair.flight.dtos.GenericResponseBuilder;
import com.ryanair.flight.services.IFlightProviderService;

@RestController
public class FlightController {

	private IFlightProviderService flightProviderService;
		
	@Autowired
	public FlightController(IFlightProviderService flightProviderService) {
		super();
		this.flightProviderService = flightProviderService;
	}
	
    @GetMapping("/v1/flight-information-tail/")
    public GenericResponse<List<RyanairFlightDto>> retrieveFlights() throws IOException {
    	return new GenericResponseBuilder<List<RyanairFlightDto>>(flightProviderService.retrieveFlights()).build();
    }


	
}
