package com.immfly.immflychallenge.amqp;

import java.util.List;

import org.springframework.messaging.handler.annotation.Payload;

import com.immfly.immflychallenge.dtos.FlightDto;

public interface AmqpConsumer {
	
	void receive (@Payload List<FlightDto> flight);
	
}
