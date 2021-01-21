package com.ryanair.flight.amqp;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ryanair.flight.dtos.RyanairFlightDto;
import com.ryanair.flight.services.IFlightProviderService;


@Component
public class FlightsQueueSender {

	Logger log = LogManager.getLogger(FlightsQueueSender.class);

	
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	@Autowired
	IFlightProviderService flightProviderService;

	@Value("${jsa.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${jsa.rabbitmq.routingkey}")
	private String routingKey;

	@Scheduled(fixedRate = 2000)
	public void produce() throws Exception{
		log.info("Sending flights");
		flightProviderService.retrieveFlights().forEach(flight -> rabbitTemplate.convertAndSend(exchange, routingKey, flight));
		flightProviderService.retrieveFlights().forEach(flight -> log.info(flight.getIdent()));
//		rabbitTemplate.convertAndSend(exchange, routingKey, flight);
//		System.out.println("Send msg = " + flight);
	}
	

}