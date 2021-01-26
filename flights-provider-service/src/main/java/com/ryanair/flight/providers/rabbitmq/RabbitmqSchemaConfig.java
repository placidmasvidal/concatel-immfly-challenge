package com.ryanair.flight.providers.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Binding.DestinationType;
import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqSchemaConfig {

	@Bean
	public Declarables createRabbitmqSchema() {
		return new Declarables(new FanoutExchange("x.altern-flight", true, false, null), new Queue("q.altern-flight"),
				new Binding("q.altern-flight", DestinationType.QUEUE, "x.altern-flight", "", null));
	}

}
