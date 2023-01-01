package com.example.redisclient;

import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class RedisClientApplication implements CommandLineRunner {

    @Autowired
    private ApplicationContext appContext;

    public static void main(String[] args) {
        SpringApplication.run(RedisClientApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        RedissonClient  redis=appContext.getBean(RedissonClient.class);

        System.out.print(redis.getKeys().count());
//        String[] beans = appContext.getBeanDefinitionNames();
//        for (String bean : beans) {
//            System.out.println("Bean name: " + bean);
//            Object object = appContext.getBean(bean);
//            System.out.println("Bean object:" + object);
//        }
    }
}
