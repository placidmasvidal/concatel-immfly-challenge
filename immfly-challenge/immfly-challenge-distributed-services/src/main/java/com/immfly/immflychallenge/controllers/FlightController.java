package com.immfly.immflychallenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.immfly.immflychallenge.dtos.FlightDto;
import com.immfly.immflychallenge.dtos.GenericResponse;
import com.immfly.immflychallenge.dtos.GenericResponseBuilder;
import com.immfly.immflychallenge.exceptions.FlightException;
import com.immfly.immflychallenge.services.IFlightService;
import com.immfly.immflychallenge.utils.ApiRoutes;

@RestController
@RequestMapping(ApiRoutes.AIRCRAFT)

public class FlightController {

	@Autowired
	private IFlightService flightService;

	@Autowired
	public FlightController(IFlightService flighttService) {
		this.flightService = flighttService;
	}
	
	@GetMapping("/{tailNumber}/{flightId}")
    public GenericResponse<FlightDto> getFlightInformationByTailNumber(
    		@PathVariable("tailNumber") String tailNumber,
    		@PathVariable("flightId") String flightId) throws FlightException{
    	return new GenericResponseBuilder<FlightDto>(flightService.getFlightByTailNumber(tailNumber, flightId)).build();
    }
	
}
