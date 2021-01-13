package com.immfly.immflychallenge.amqp;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.immfly.immflychallenge.services.clients.IFlightsClient;

@Component
public class FlightsConsumer {

	@Autowired
	private IFlightsClient flightsClient;
	
	@RabbitListener(queues = {"${queue.flights.name}"})
    public void receive(@Payload String ident) {
//		flightsClient.getFlights();
	}
	
}
