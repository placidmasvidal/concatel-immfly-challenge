package com.immfly.immflychallenge.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class FlightCustomJpaRepositoryImpl implements FlightCustomJpaRepository{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	


}
