package com.example.redisclient;


import io.netty.util.Timeout;
import org.rajman.common.scorelibrary.service.ScoreService;
import org.redisson.api.RedissonClient;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class RedisClientApplication {



  static ScoreService scoreService;

    public RedisClientApplication(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext context = SpringApplication.run(RedisClientApplication.class, args);
        System.out.println(scoreService.getScore(100));
        System.out.println(scoreService.getScore(1040));
        Thread.sleep(30 * 1000);
        System.out.println(scoreService.getScore(1030));
    }

}
