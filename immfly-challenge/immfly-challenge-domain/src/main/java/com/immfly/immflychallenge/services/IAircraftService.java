package com.immfly.immflychallenge.services;

import java.util.Optional;

import com.immfly.immflychallenge.entities.Aircraft;
import com.immfly.immflychallenge.exceptions.AircraftException;

public interface IAircraftService {
	Optional<Aircraft> findByAircraftId(Long aircraftId) throws AircraftException;
}
