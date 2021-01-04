package com.immfly.immflychallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableRedisRepositories(basePackages = "com.immfly.immflychallenge")
public class ImmflyChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImmflyChallengeApplication.class, args);
	}

}
