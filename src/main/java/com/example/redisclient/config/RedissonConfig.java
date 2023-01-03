package com.example.redisclient.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class RedissonConfig {


    final RedissonProperties redissonProperties;

    public RedissonConfig(RedissonProperties redissonProperties) {
        this.redissonProperties = redissonProperties;
    }

    @Bean
    public RedissonClient RedissonConfig(){
        Config config=new Config();
        if(redissonProperties.isCluster()){
             config.useClusterServers()
                     .setPassword(redissonProperties.getPassword());
//                     .setNodeAddresses();
        } else{
            config.useSingleServer().setAddress(redissonProperties.getAddress());
            if( redissonProperties.getPassword()!=null)
                config.useSingleServer().setPassword (redissonProperties.getPassword());
        }
        return Redisson.create(config);
    }
}
