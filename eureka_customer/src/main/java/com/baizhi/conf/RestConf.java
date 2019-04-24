package com.baizhi.conf;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration   //放入工厂
public class RestConf {
    @Bean
    @LoadBalanced      //开启负载均衡
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
