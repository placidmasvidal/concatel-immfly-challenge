package com.immfly.immflychallenge.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.immfly.immflychallenge.entities.Flight;

public interface FlightJpaRepository extends JpaRepository<Flight, String>, FlightCustomJpaRepository {
	
	Optional<Flight> findById (String Id);
		
}
