package com.immfly.immflychallenge.config;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.ReactiveKeyCommands;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.connection.ReactiveStringCommands;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.immfly.immflychallenge.entities.Flight;


@Configuration
@ComponentScan("com.immfly.immflychallenge")
@EnableRedisRepositories(basePackages = "com.immfly.immflychallenge")
@PropertySource("classpath:application.properties")
public class RedisConfig {

    @Autowired
    RedisConnectionFactory factory;
	

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory();
    }
    
/*    @Bean()
    public ReactiveRedisTemplate<String, Flight> reactiveRedisTemplate(ReactiveRedisConnectionFactory factory) {
        Jackson2JsonRedisSerializer<Flight> serializer = new Jackson2JsonRedisSerializer<>(Flight.class);
        RedisSerializationContext.RedisSerializationContextBuilder<String, Flight> builder = RedisSerializationContext.newSerializationContext(new StringRedisSerializer());
        RedisSerializationContext<String, Flight> context = builder.value(serializer)
            .build();
        return new ReactiveRedisTemplate<>(factory, context);
    }*/
	
    @Bean("redisTemplate")
    @ConditionalOnMissingBean(name = "redisTemplate")
    public RedisTemplate<String, Object> redisTemplate() {
    	final RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
    	template.setConnectionFactory(jedisConnectionFactory());
    	template.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
    	return template;
    }
    
 /*   @Bean
    public ReactiveKeyCommands keyCommands(final ReactiveRedisConnectionFactory reactiveRedisConnectionFactory) {
        return reactiveRedisConnectionFactory.getReactiveConnection()
            .keyCommands();
    }

    @Bean
    public ReactiveStringCommands stringCommands(final ReactiveRedisConnectionFactory reactiveRedisConnectionFactory) {
        return reactiveRedisConnectionFactory.getReactiveConnection()
            .stringCommands();
    }
*/
    @Bean("channelTopic")
    ChannelTopic topic() {
        return new ChannelTopic("messageQueue");
    }
    
    @PreDestroy
    public void cleanRedis() {
        factory.getConnection()
            .flushDb();
    }
}