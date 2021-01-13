package com.immfly.immflychallenge.amqp;

import org.springframework.messaging.handler.annotation.Payload;

public interface AmqpConsumer {
	
	void receive (@Payload String ident);
	
}
