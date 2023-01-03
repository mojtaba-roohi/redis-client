package com.example.redisclient.config;

import com.example.redisclient.model.RedissonProperty;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

//@Configuration
public class Redisson {

    @Bean
    public RedissonClient Redisson(RedissonProperty redissonProperty){
        Config config=new Config();
        
        System.out.println("redis-client-connect");
        if(redissonProperty.isCluster()){
             config.useClusterServers()
                     .setPassword(redissonProperty.getPassword());
//                     .setNodeAddresses();
        } else{
            config.useSingleServer().setAddress(redissonProperty.getAddress());
            if( redissonProperty.getPassword()!=null)
                config.useSingleServer().setPassword (redissonProperty.getPassword());
        }
        return org.redisson.Redisson.create(config);
    }

    @Bean
    @ConfigurationProperties(prefix = "scores-redis")
    public RedissonProperty redissonProperty() {
        return new RedissonProperty();
    }
}
