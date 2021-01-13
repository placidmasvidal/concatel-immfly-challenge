package com.immfly.immflychallenge.amqp;

import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.immfly.immflychallenge.dtos.FlightDto;
import com.immfly.immflychallenge.services.clients.IFlightsClient;

@Component
public class FlightsConsumer implements AmqpConsumer{

	@Autowired
	private IFlightsClient flightsClient;
	
	@Override
	@Scheduled(fixedRate = 2000)
	@RabbitListener(queues = {"${jsa.rabbitmq.queue}"})
    public void receive(@Payload List<FlightDto> flight) {
//		flightsClient.getFlightsFromQueue(flight);
	}
		
}
