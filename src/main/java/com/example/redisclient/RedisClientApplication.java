package com.example.redisclient;


import org.rajman.common.scores.service.ScoreService;
import org.redisson.api.RedissonClient;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class RedisClientApplication {
//static String SCORE_FILL_SCORE_CACHE_QUEUE_NAME = "score.fill_score_cache";

//    @Autowired
//   static RabbitTemplate rabbitTemplate;
//
//    public RedisClientApplication(RabbitTemplate rabbitTemplate) {
//        this.rabbitTemplate = rabbitTemplate;
//    }


  static ScoreService scoreService;

    public RedisClientApplication(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(RedisClientApplication.class, args);
//        rabbitTemplate.convertAndSend(SCORE_FILL_SCORE_CACHE_QUEUE_NAME,1002);
        Object m= scoreService.getScore(100);
        System.out.println(m);
        try{
            RedissonClient redis = context.getBean(RedissonClient.class);
            System.out.print("redis keys Count: " + redis.getKeys().count());
        } catch (NoSuchBeanDefinitionException ex){
            System.out.println("not connect to redisson ");
        }

    }

}
