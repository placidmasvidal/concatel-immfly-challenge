package com.immfly.immflychallenge.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.immfly.immflychallenge.entities.Aircraft;
import com.immfly.immflychallenge.exceptions.AircraftException;
import com.immfly.immflychallenge.generic.GenericRepository;
import com.immfly.immflychallenge.repositories.AircraftRepository;

@Service
public class AircraftServiceImpl implements IAircraftService {

	private final AircraftRepository aircraftRepository;
	private GenericRepository genericRepository;

	@Autowired
	public AircraftServiceImpl(AircraftRepository aircraftRepository, 
			GenericRepository genericRepository) {
		this.aircraftRepository = aircraftRepository;
		this.genericRepository = genericRepository;
	}

	@Override
	public Optional<Aircraft> findByAircraftId(Long aircraftId) throws AircraftException {
		Optional<Aircraft> result = aircraftRepository.findByAircraftId(aircraftId);
		if(!result.isPresent()) {
			throw new AircraftException("Aircraft could not be found with aircraft id = " + aircraftId);
		}
		return result;
	}

}
