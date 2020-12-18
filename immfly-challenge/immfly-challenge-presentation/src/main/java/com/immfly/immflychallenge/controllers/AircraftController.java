package com.immfly.immflychallenge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiRoutes.AIRCRAFT)
public class AircraftController {

	@Autowired
	private IAircraftService aircraftService;

	@Autowired
	public AircraftController(IAircraftService aircraftService) {
		this.aircraftService = aircraftService;
	}

	@GetMapping(ApiRoutes.AIRCRAFT_RETRIEVE_FLIGHTS_PAGE)
	public GenericResponse<List<FlightDto>> retrieveFlightsByAircraftId(@PathVariable("tailNumber") Long tailNumber)
			throws AircraftException {
		return new GenericResponseBuilder<List<FlightDto>>(aircraftService.getFlightsByAircraftId(tailNumber)).build();
	}

	
}
