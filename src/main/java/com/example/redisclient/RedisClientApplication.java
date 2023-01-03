package com.example.redisclient;


import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
@EnableAutoConfiguration
public class RedisClientApplication {


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(RedisClientApplication.class, args);

        try{
            RedissonClient redis = context.getBean(RedissonClient.class);
            System.out.print("redis keys Count: " + redis.getKeys().count());
        } catch (NoSuchBeanDefinitionException ex){
            System.out.println("not connect to redisson ");
        }

    }

}
