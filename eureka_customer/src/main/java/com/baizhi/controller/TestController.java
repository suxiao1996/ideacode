package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.feign.TestFeign;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@RestController
@RequestMapping("test")
public class TestController {

//    @Autowired
//    private LoadBalancerClient loadBalancerClient;
//    @Autowired
//    private RestTemplate restTemplate;
    @Autowired
    private TestFeign testFeign;

//    @RequestMapping("test")
//    public String test(String name,String password,Integer age){
//        RestTemplate 帮助发送http请求 进行远程调用
//        第一种RestTemplate调用方式  写死
//        RestTemplate restTemplate = new RestTemplate();
//        String forObject = restTemplate.getForObject("http://localhost:1997/hello/hello?name=" + name, String.class);

//        第二种        负载均衡客户端 通过cloent1实例名拿到  localhost：端口号
//        ServiceInstance instance = loadBalancerClient.choose("eureka-client");
//        String forObject = restTemplate.getForObject("http://"+instance.getHost() + ":" + instance.getPort() + "/hello/hello?name=" + name, String.class);
//        System.out.println(instance.getHost() + ":" + instance.getPort()); //10.102.114.91:1997  网络地址

//        第三种    conf/RestTemplateConf 从工厂中获取               实例名
//        HashMap map = new HashMap();
//        map.put("name",name);
//        map.put("password",password);
//        map.put("age",age);
//        String forObject = restTemplate.getForObject("http://eureka-client/hello/hello?name={name}&password={password}&age={age}", String.class,map);
//        return forObject;
//    }

    @RequestMapping(value = "feign",method = RequestMethod.GET)
    public String feign(String name,String password,Integer age){
        String hello = testFeign.hello(name,password,age);
        return hello;
    }

    @RequestMapping(value = "feignUser")
    public User feignUser(User user){
        User user1 = testFeign.hallo(user);
        return user1;
    }


//    测试hystric容错处理
//    @RequestMapping("test")
//    @HystrixCommand(fallbackMethod = "fallback")
//    public String test(String name){
//        String forObject = restTemplate.getForObject("http://eureka-client/hello/hello?name="+name, String.class);
//        return forObject;
//    }
//    public String fallback(String name){
//        return "error";
//    }

}
