package com.immfly.immflychallenge.consumers.rabbitmq.schedulers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
public class RabbitmqScheduler {

	@Autowired
	private RabbitListenerEndpointRegistry registry;

	private static final Logger log = LoggerFactory.getLogger(RabbitmqScheduler.class);

	@Scheduled(cron = "0 0 23 * * ?")
	public void stopAll() {
		registry.getListenerContainers().forEach(c -> {
			log.info("Stopping container : {}", c);
			c.stop();
		});
	}

	@Scheduled(cron = "1 0 0 * * ?")
	public void startAll() {
		registry.getListenerContainers().forEach(c -> {
			log.info("Starting container : {}", c);
			c.start();
		});
	}

}
