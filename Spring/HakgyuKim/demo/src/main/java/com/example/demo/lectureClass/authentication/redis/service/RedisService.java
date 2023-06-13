package com.example.demo.lectureClass.authentication.redis.service;

public interface RedisService {

    void setKeyAndValue(String token, Long accountId);
    Long getValueByKey(String token);
    void deleteByKey(String token);
}
