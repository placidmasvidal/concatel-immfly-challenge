package com.ryanair.flight.amqp;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ryanair.flight.dtos.RyanairFlightDto;

@Component
public class FlightsQueueSender {
/*
	@Autowired
	private AmqpTemplate rabbitTemplate;

	@Value("${jsa.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${jsa.rabbitmq.routingkey}")
	private String routingKey;

	@Scheduled(fixedRate = 2000)
	public void produce(RyanairFlightDto flight){
		rabbitTemplate.convertAndSend(exchange, routingKey, flight);
		System.out.println("Send msg = " + flight);
	}
	*/

}