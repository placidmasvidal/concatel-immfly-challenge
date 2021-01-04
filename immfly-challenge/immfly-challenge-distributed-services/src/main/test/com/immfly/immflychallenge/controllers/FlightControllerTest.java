package com.immfly.immflychallenge.controllers;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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
	void test() {
		fail("Not yet implemented");
	}

}
