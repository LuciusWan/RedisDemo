package com.lucius.redisdemo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucius.redisdemo.Tool.RedisTool;
import com.lucius.redisdemo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
public class RedisStringTest {
    public static final ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Test
    void RedisTest2() throws JsonProcessingException {
        User user1=new User();
        user1.setId(1);
        user1.setAge(18);
        user1.setEmail("18099488938@163.com");
        user1.setPassword("123456");
        user1.setUsername("Lucius");
        stringRedisTemplate.opsForValue().set("user:name:4", RedisTool.ObjectToString(user1));
        User user=objectMapper.readValue(stringRedisTemplate.opsForValue().get("user:name:4"), User.class);
        System.out.println(user);
    }
}
