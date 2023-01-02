package com.example.redisclient.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisonConfig {

    @Autowired
    private RedisonProperties redisonProperties;

    @Bean
    @ConditionalOnProperty(prefix = "scores-redis" , name = "address")
    public RedissonClient RedisonConfig(){
        Config config=new Config();
        if(redisonProperties.isCluster()){
             config.useClusterServers()
                     .setPassword(redisonProperties.getPassword());
//                     .setNodeAddresses();
        } else{
            config.useSingleServer().setAddress(redisonProperties.getAddress());
            if( redisonProperties.getPassword()!=null)
                config.useSingleServer().setPassword (redisonProperties.getPassword());
        }
        return Redisson.create(config);
    }
}
