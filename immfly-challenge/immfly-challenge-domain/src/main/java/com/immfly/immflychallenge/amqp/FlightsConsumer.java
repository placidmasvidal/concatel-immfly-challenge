package com.immfly.immflychallenge.amqp;

import java.util.List;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.immfly.immflychallenge.dtos.FlightDto;
import com.immfly.immflychallenge.entities.Flight;
import com.immfly.immflychallenge.mappers.IFlightMapper;
import com.immfly.immflychallenge.repositories.FlightJpaRepository;
import com.immfly.immflychallenge.services.clients.IFlightsClient;

@Component
public class FlightsConsumer implements AmqpConsumer{

	
	@Autowired
	private FlightJpaRepository flightJpaRepository;
	
	@Autowired
	private IFlightMapper flightMapper;
	
	@Override
	@RabbitListener(queues = "jsa.flights.queue")
    public void receive(@Payload List<FlightDto> flightsDtos, @Headers MessageHeaders headers, Message message) {
    	List<Flight> flights = flightMapper.mapFromDtoList(flightsDtos);
    	flights.forEach(flight -> flightJpaRepository.save(flight));

	}
		
}
