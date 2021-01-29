package com.immfly.immflychallenge.services;

import java.util.List;
import java.util.Optional;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.immfly.immflychallenge.amqp.AmqpConsumer;
import com.immfly.immflychallenge.dtos.FlightDto;
import com.immfly.immflychallenge.entities.Flight;
import com.immfly.immflychallenge.exceptions.FlightException;
import com.immfly.immflychallenge.mappers.IFlightMapper;
import com.immfly.immflychallenge.repositories.FlightJpaRepository;
import com.immfly.immflychallenge.services.clients.IFlightsClient;

@Service
public class FlightServiceImpl implements IFlightService {

	private IFlightsClient flightsClient;
	
	private FlightJpaRepository flightJpaRepository;
	
	private IFlightMapper flightMapper;
	
//	private AmqpConsumer flightsConsumer;
	
	@Autowired
	public FlightServiceImpl(IFlightsClient flightsClient,
			FlightJpaRepository flightJpaRepository,
			IFlightMapper flightMapper/*,
			AmqpConsumer flightsConsumer*/) {
		this.flightsClient = flightsClient;
		this.flightJpaRepository = flightJpaRepository;
		this.flightMapper = flightMapper;
//		this.flightsConsumer = flightsConsumer;
	}

	@Override
	public FlightDto getFlightById (String id) throws FlightException{
		
		Optional<Flight> entity = flightJpaRepository.findById(id);
		
		if(!entity.isPresent()) {
			throw new FlightException("Couldn't find flight with flight id = " + id);
		}
		
		return flightMapper.mapToDto(entity.get());
		
	}

	@Override
	public FlightDto getFlightByTailNumber(String tailNumber, String flightId) throws FlightException{
						
		List<Flight> flightsEntities = flightJpaRepository.findAll();
		
		List<FlightDto> flightsDtos = flightMapper.mapToDtoList(flightsEntities);
		
		Optional<FlightDto> flight = flightsDtos.stream()
				.filter(x -> x.getId().equals(flightId))
				.findFirst();
		
		if(!flight.isPresent()) {
			throw new FlightException("Couldn't find flight with flight id = " + flightId);
		}
		
		return flight.get();
		
	}


//	@Scheduled(cron = "0 * * * * ?")
	@RabbitListener(queues = "flight-queue")
	@Transactional
	private void checkForFlightsProcess() {
		flightsClient.getFlights();
	}
	
}
