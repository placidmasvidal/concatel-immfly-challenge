package com.immfly.immflychallenge.redis.config;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

import com.immfly.immflychallenge.entities.Flight;

@Configuration
@ComponentScan("com.immfly.immflychallenge")
@EnableRedisRepositories(basePackages = "com.immfly.immflychallenge")
@PropertySource("classpath:application.properties")
public class RedisConfig {

	Logger LOGGER = LogManager.getLogger(RedisConfig.class);
	
    @Bean
	@Autowired
    public RedisTemplate<String, Flight> redisFlightTemplate(RedisConnectionFactory connectionFactory) {

        RedisTemplate<String, Flight> redisTemplate = new RedisTemplate<>();

        redisTemplate.setConnectionFactory(connectionFactory);

        redisTemplate.afterPropertiesSet();

         return redisTemplate;

    }

}