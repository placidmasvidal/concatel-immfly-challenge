package com.immfly.immflychallenge.repositories;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.immfly.immflychallenge.entities.Flight;

public interface FlightRepository extends BaseRepository<Flight, String>, QuerydslPredicateExecutor<Flight> { }
