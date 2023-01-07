package com.example.redisclient.config;

import com.example.redisclient.model.RedissonModel;
import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.Config;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Redisson {

    @Bean
    public RedissonClient Redisson(RedissonModel redissonModel){
        Config config=new Config();
        config.setCodec(new JsonJacksonCodec());
        System.out.println("redis-client-connect");
        if(redissonModel.isCluster()){
             config.useClusterServers()
                     .setPassword(redissonModel.getPassword());
//                     .setNodeAddresses();
        } else{
            config.useSingleServer().setAddress(redissonModel.getAddress());
            if( redissonModel.getPassword()!=null)
                config.useSingleServer().setPassword (redissonModel.getPassword());
        }
        return org.redisson.Redisson.create(config);
    }

    @Bean
    @ConfigurationProperties(prefix = "scores.redis")
    public RedissonModel redissonModel() {
        return new RedissonModel();
    }
}
