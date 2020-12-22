package com.immfly.immflychallenge.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.immfly.immflychallenge.entities.Aircraft;
import com.immfly.immflychallenge.exceptions.AircraftException;
import com.immfly.immflychallenge.generic.CustomRepository;

@Repository
public interface AircraftRepository extends JpaRepository<Aircraft, Long>, CustomRepository {

	Optional<Aircraft> findByAircraftId(Long aircraftId) throws AircraftException;

}