package com.lucius.redisdemo.Tool;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RedisTool {
    public static final ObjectMapper objectMapper = new ObjectMapper();
    public static String ObjectToString(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }
    public static Object StringToObject(String string) throws JsonProcessingException {
        return objectMapper.readValue(string, Object.class);
    }
}
