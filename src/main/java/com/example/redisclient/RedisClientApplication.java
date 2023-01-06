package com.example.redisclient;


import org.rajman.common.scores.service.ScoreService;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class RedisClientApplication {

  static  ScoreService scoreService;

    public RedisClientApplication(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(RedisClientApplication.class, args);

        Integer m= scoreService.getScore("abo");
        System.out.println(m);
        try{
            RedissonClient redis = context.getBean(RedissonClient.class);
            System.out.print("redis keys Count: " + redis.getKeys().count());
        } catch (NoSuchBeanDefinitionException ex){
            System.out.println("not connect to redisson ");
        }

    }

}
