package com.immfly.immflychallenge.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.immfly.immflychallenge.dtos.FlightDto;
import com.immfly.immflychallenge.entities.Aircraft;
import com.immfly.immflychallenge.entities.Flight;
import com.immfly.immflychallenge.exceptions.AircraftException;
import com.immfly.immflychallenge.mappers.IFlightMapper;
import com.immfly.immflychallenge.repositories.AircraftRepository;

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

//		Optional<Aircraft> aircraft = aircraftRepository.findById(aircraftId);
		Optional<Aircraft> aircraft = null;	//FIXME

		if (!aircraft.isPresent()) {
			throw new AircraftException("Aircraft not found in database. Tail Number: " + aircraftId);
		}

		return aircraft.get();
	}

}
