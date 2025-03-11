package com.lucius.redisdemo.Controller;

import com.lucius.redisdemo.pojo.User;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class TestController {
    private static final Logger logger = LogManager.getLogger(TestController.class);
    @Autowired
    private RedisTemplate redisTemplate;
    @GetMapping("/test")
    public String test() {
        String user=(String) redisTemplate.opsForValue().get("user:name:2");
        logger.info("test启动{}",user);
        User user1=new User();
        user1.setId(1);
        user1.setAge(18);
        user1.setEmail("18099488938@163.com");
        user1.setPassword("123456");
        user1.setUsername("Lucius");
        String users=user1.toString();
        redisTemplate.opsForValue().set("user:name:3", users);
        logger.info("插入对象user1{}",user1);
        Object user2= redisTemplate.opsForValue().get("user:name:3");
        logger.info("user2查询结果为{}",user2);
        return user;
    }
}
