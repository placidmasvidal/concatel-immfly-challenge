package com.immfly.immflychallenge.config;
import javax.annotation.PreDestroy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.GenericToStringSerializer;


@Configuration
@ComponentScan("com.immfly.immflychallenge")
@EnableRedisRepositories(basePackages = "com.immfly.immflychallenge")
@PropertySource("classpath:application.properties")
public class RedisConfig {

	Logger LOGGER = LogManager.getLogger(RedisConfig.class);
	
    @Autowired
    RedisConnectionFactory factory;
  
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
    }

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