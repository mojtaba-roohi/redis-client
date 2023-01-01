package com.example.redisclient.config;


import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;

public class RedisConfig {

    private RedissonClient redisson;

    @Bean
    public RedissonClient redissonClient() throws IOException {

        String configFileName = "redis.yml";
        File resourceURL = ResourceUtils.getFile("classpath:" + configFileName);
        Config config = Config.fromYAML(resourceURL);
        redisson = Redisson.create(config);
        return redisson;
    }



}
