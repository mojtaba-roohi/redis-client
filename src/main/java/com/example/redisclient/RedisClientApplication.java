package com.example.redisclient;


import org.redisson.api.RedissonClient;
import org.redisson.spring.starter.RedissonAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
@EnableAutoConfiguration(exclude = {RedissonAutoConfiguration.class})
public class RedisClientApplication {


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(RedisClientApplication.class, args);

        RedissonClient redis = context.getBean(RedissonClient.class);
        System.out.print("redis keys Count: " + redis.getKeys().count());
    }

}
