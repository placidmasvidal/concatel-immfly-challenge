package com.immfly.immflychallenge;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableRabbit
@EnableScheduling
@EnableRedisRepositories(basePackages = "com.immfly.immflychallenge")
public class ImmflyChallengeApplication {

	@Value("${queue.flights.name}")
    private String flightsQueue;
	
	public static void main(String[] args) {
		SpringApplication.run(ImmflyChallengeApplication.class, args);
	}
	
	@Bean
    public Queue queue() {
        return new Queue(flightsQueue, true);
    }

}
