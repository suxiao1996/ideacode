package com.baizhi.feign;

import com.baizhi.entity.User;

public class TestFeignImpl implements TestFeign{
    @Override
    public String hello(String name, String password, Integer age) {
        return "name,password,age";
    }

    @Override
    public User hallo(User user) {
        User user1 = new User();
        user1.setName("rrrr");
        return user1;
    }
}
