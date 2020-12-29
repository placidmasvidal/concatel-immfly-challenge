package com.immfly.immflychallenge.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.immfly.immflychallenge.repositories.FlightCustomJpaRepository;

public class FlightCustomJpaRepositoryImpl implements FlightCustomJpaRepository{
	
	@PersistenceContext
	private EntityManager entityManager;
	

}
