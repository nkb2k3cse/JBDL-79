package com.example.L16_minor_project_01.config;

import com.example.L16_minor_project_01.dto.SearchProductDto;
import com.example.L16_minor_project_01.entity.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, SearchProductDto> productRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, SearchProductDto> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new Jackson2JsonRedisSerializer<SearchProductDto>(SearchProductDto.class));
        return template;
    }
}
