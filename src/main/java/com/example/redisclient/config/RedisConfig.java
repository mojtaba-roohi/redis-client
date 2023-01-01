package com.example.redisclient.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.spring.data.connection.RedissonConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;

public class RedisConfig {
    private RedissonClient redisson;
    @Bean(destroyMethod = "shutdown")
    public RedissonClient redissonClient() throws IOException {
        String configFileName = "redis.yml";
        File resourceURL = ResourceUtils.getFile("classpath:" + configFileName);
        Config config = Config.fromYAML(resourceURL);
        redisson = Redisson.create(config);
        return redisson;
    }

//    @Bean
//    public RedisConnectionFactory redissonConnectionFactory(RedissonClient redissonClient) {
//        return new RedissonConnectionFactory(redissonClient);
//    }
//
//    @Bean
//    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redissonConnectionFactory) {
//        RedisTemplate<String, Object> template = new RedisTemplate<>();
//        template.setConnectionFactory(redissonConnectionFactory);
//        template.setKeySerializer(new StringRedisSerializer());
//        template.setValueSerializer(new StringRedisSerializer());
//        return template;
//    }


}
