package com.lucius.redisdemo;

import com.alibaba.fastjson.JSON;
import jakarta.annotation.Resource;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

@SpringBootTest
class RedisDemoApplicationTests {
	@Autowired
	private RedisTemplate redisTemplate;
	@Test
	void RedisTest1(){
		redisTemplate.opsForValue().set("user:name:1","jack");
		Object name= redisTemplate.opsForValue().get("user:name:1");
		System.out.println(name);
	}
	@Test
	void RedisTest2(){
		Map<String,String> map	=new HashMap();
		map.put("name","jack");
		map.put("age","18");
		map.put("job","coder");
		String json= JSON.toJSONString(map);
		redisTemplate.opsForValue().set("user:name:2",json);
		Object name=redisTemplate.opsForValue().get("user:name:2");
		System.out.println(name);
	}

}
