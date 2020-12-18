package com.immfly.immflychallenge.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AircraftService implements IAircraftService {

	private final AircraftRepository aircraftRepository;
	private final IFlightMapper iFlightMapper;

	@Autowired
	public AircraftService(AircraftRepository aircraftRepository, IFlightMapper iFlightMapper) {
		this.aircraftRepository = aircraftRepository;
		this.iFlightMapper = iFlightMapper;
	}

	@Override
	public List<FlightDto> getFlightsByAircraftId(Long aircraftId) throws AircraftException {
		Aircraft aircraft = getFlightsByAircraftIdOperation(aircraftId);

		List<Flight> flights = aircraft.getFlights();

		return iFlightMapper.mapToDtoList(flights);
	}

	private Aircraft getFlightsByAircraftIdOperation(Long aircraftId) throws AircraftException {

		Optional<Aircraft> aircraft = aircraftRepository.findById(aircraftId);

		if (!aircraft.isPresent()) {
			throw new AircraftException("Aircraft not found in database. Tail Number: " + aircraftId);
		}

		return aircraft.get();
	}

}
