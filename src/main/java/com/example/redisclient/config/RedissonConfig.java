package com.example.redisclient.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class RedissonConfig {


    final RedissonClientProperties redissonClientProperties;

    public RedissonConfig(RedissonClientProperties redissonClientProperties) {
        this.redissonClientProperties = redissonClientProperties;
    }

    @Bean
    public RedissonClient RedissonConfig(){
        Config config=new Config();
        System.out.println("redis-client-connect");
        if(redissonClientProperties.isCluster()){
             config.useClusterServers()
                     .setPassword(redissonClientProperties.getPassword());
//                     .setNodeAddresses();
        } else{
            config.useSingleServer().setAddress(redissonClientProperties.getAddress());
            if( redissonClientProperties.getPassword()!=null)
                config.useSingleServer().setPassword (redissonClientProperties.getPassword());
        }
        return Redisson.create(config);
    }
}
