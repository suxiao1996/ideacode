package com.baizhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
//客户端
@EnableEurekaClient    //只能向Eureka注册中心做注册
//@EnableDiscoveryClient //...还可以向Zookpeer中做注册
@EnableFeignClients   //开启feign支持
@EnableHystrix   //开启使用hystrix实现微服务的容错处理
public class EurekaCustomerApplication {

    public static void main(String[] args) {
        System.out.println(111);
        SpringApplication.run(EurekaCustomerApplication.class, args);
    }

}
