package com.ryanair.flight.providers.rabbitmq.producers;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryanair.flight.providers.rabbitmq.dtos.RyanairFlightInfo;

@Service
public class FlightProducer {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void sendDummy(RyanairFlightInfo flightInfo) {
		rabbitTemplate.convertAndSend("x.flight", "", flightInfo);
	}
	
}
