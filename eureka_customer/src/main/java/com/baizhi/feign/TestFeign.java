package com.baizhi.feign;

import com.baizhi.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//绑定servince的id
@FeignClient(serviceId = "eureka-client",fallback = TestFeignImpl.class)
public interface TestFeign {

//单参 多参类型
    @RequestMapping(value = "/hello/hello",method = RequestMethod.GET)
    public String hello(@RequestParam("name")String name,@RequestParam("password") String password,@RequestParam("age") Integer age);

//对象类型
    @RequestMapping(value = "/hello/hallo",method = RequestMethod.POST)
    public User hallo(User user);

}
