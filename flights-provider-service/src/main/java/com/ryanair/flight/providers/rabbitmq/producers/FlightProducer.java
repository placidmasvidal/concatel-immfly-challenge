package com.ryanair.flight.providers.rabbitmq.producers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class FlightProducer {

	private static final Logger LOGGER = LoggerFactory.getLogger(FlightProducer.class);

	public void sendMessage(RabbitTemplate rabbitTemplate,
							String flightExchange,
							String flightRoutingKey,
							Object flightData) {
		
		LOGGER.info("Sending message to the flight queue using routing key: {}, Message: {}", flightRoutingKey, flightData);
		
		rabbitTemplate.convertAndSend(flightExchange, flightRoutingKey, flightData);
		
		LOGGER.info("Flight message was sent");
	}
	
}
