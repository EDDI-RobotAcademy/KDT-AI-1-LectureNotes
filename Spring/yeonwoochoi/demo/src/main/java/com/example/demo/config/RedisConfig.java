package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisConfig {

    private String redisHost;
    private String redisPort;
    private String redisPassword;

    @Bean
    public RedisConnectionFactory redisConnectionFactory () {

    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {

    }
}
