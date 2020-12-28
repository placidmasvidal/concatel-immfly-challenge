package com.immfly.immflychallenge.redis.config;
import javax.annotation.PreDestroy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.ReactiveKeyCommands;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.connection.ReactiveStringCommands;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.immfly.immflychallenge.redis.model.Flight;

@Configuration
@ComponentScan("com.immfly.immflychallenge")
@EnableRedisRepositories(basePackages = "com.immfly.immflychallenge")
@PropertySource("classpath:application.properties")
public class RedisConfig {

	Logger LOGGER = LogManager.getLogger(RedisConfig.class);
	
    @Autowired
    RedisConnectionFactory factory;
    /*  
    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jedisConnectionFactory = null;
        
        try {
            jedisConnectionFactory = new JedisConnectionFactory();
            jedisConnectionFactory.getPoolConfig().setMaxTotal(10);
            jedisConnectionFactory.getPoolConfig().setMaxIdle(8);
            jedisConnectionFactory.getPoolConfig().setMinIdle(1);
        } catch (RedisConnectionFailureException e) {
            LOGGER.error("Connection break with redis " + e.getMessage());
        }

        return jedisConnectionFactory;
    }
	
    @Bean("redisTemplate")
    public RedisTemplate<String, Object> redisTemplate() {
    	final RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
    	template.setConnectionFactory(jedisConnectionFactory());
    	template.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
    	template.setEnableTransactionSupport(true);
    	return template;
    }*/

    @Bean
    public ReactiveRedisTemplate<String, Flight> reactiveRedisTemplate(ReactiveRedisConnectionFactory factory) {
        Jackson2JsonRedisSerializer<Flight> serializer = new Jackson2JsonRedisSerializer<>(Flight.class);
        RedisSerializationContext.RedisSerializationContextBuilder<String, Flight> builder = RedisSerializationContext.newSerializationContext(new StringRedisSerializer());
        RedisSerializationContext<String, Flight> context = builder.value(serializer)
            .build();
        return new ReactiveRedisTemplate<>(factory, context);
    }

    @Bean
    public ReactiveKeyCommands keyCommands(final ReactiveRedisConnectionFactory reactiveRedisConnectionFactory) {
        return reactiveRedisConnectionFactory.getReactiveConnection()
            .keyCommands();
    }

    @Bean
    public ReactiveStringCommands stringCommands(final ReactiveRedisConnectionFactory reactiveRedisConnectionFactory) {
        return reactiveRedisConnectionFactory.getReactiveConnection()
            .stringCommands();
    }

    @PreDestroy
    public void cleanRedis() {
        factory.getConnection()
            .flushDb();
    }
	
    @Bean("channelTopic")
    ChannelTopic topic() {
        return new ChannelTopic("messageQueue");
    }
    

}