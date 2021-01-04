package com.immfly.immflychallenge.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.immfly.immflychallenge.exceptions.FlightException;
import com.immfly.immflychallenge.mappers.IFlightMapper;
import com.immfly.immflychallenge.repositories.FlightJpaRepository;
import com.immfly.immflychallenge.services.clients.IFlightsClient;

class FlightServiceImplTest {

	private IFlightService flightServiceSut;
	
	@Mock
	private IFlightsClient flightsClient;

	@Mock
	private FlightJpaRepository flightJpaRepository;

	@Mock
	private IFlightMapper flightMapper;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		flightServiceSut = new FlightServiceImpl(flightsClient,
				flightJpaRepository,
				flightMapper);
	}

	@Test
	void When_getFlightByTailNumberCalledThenReturn() throws FlightException {
		Assertions.assertThrows(FlightException.class, () -> {
		    flightServiceSut.getFlightByTailNumber("tailNumber","flightId");
		  });
	}
	
	@Test
	void When_getFlightByIdCalledThenReturn() throws FlightException {
		Assertions.assertThrows(FlightException.class, () -> {
		    flightServiceSut.getFlightById("flightId");
		  });
	}

}
