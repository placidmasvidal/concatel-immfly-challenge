package com.immfly.immflychallenge.controllers;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.immfly.immflychallenge.dtos.FlightDto;
import com.immfly.immflychallenge.dtos.GenericResponse;
import com.immfly.immflychallenge.exceptions.FlightException;
import com.immfly.immflychallenge.services.IFlightService;


class FlightControllerTest {

	private FlightController flightControllerSut;
	
	@Mock
	private IFlightService flightService;
	
	@BeforeEach
	void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        flightControllerSut = new FlightController(flightService);
	}

	@Test
	void When_getFlightInformationByTailNumberCalledThen() throws FlightException {
		GenericResponse<FlightDto> response = flightControllerSut.getFlightInformationByTailNumber("tailNumber","flightId");
		
		assertNotNull(response);
		
	}

}
