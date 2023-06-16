package com.example.demo.lectureClass.authentication.redis;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Slf4j
@Service
@RequiredArgsConstructor
public class RedisServiceImpl implements RedisService{

    final private StringRedisTemplate redisTemplate;

    @Override
    public void setKeyAndValue(String token, Long accountId) {
        String accountIdToString = String.valueOf(accountId);
        ValueOperations<String, String> value = redisTemplate.opsForValue();
        // ValueOperations<key, value>
        // Redis에서 값을 저장하고 검색하는데 사용할 수 있는 ValueOperations 인터페이스
        value.set(token, accountIdToString, Duration.ofMinutes(3));
        // Redis에 token이라는 key와 accountIdtoString이라는 value를 저장하며
        // 유효기간은 3분

        // 즉, Redis에 key와 value를 3분 간 저장하는 메서드
    }

    @Override
    public Long getValueByKey(String token) {
        ValueOperations<String, String> value = redisTemplate.opsForValue();
        String tmpAccountId = value.get(token);
        // 저장한 token으로 value를 가져와서 tmpAccountId에 저장해줌
        Long accountId;

        if (tmpAccountId == null) {
            accountId = null;
        } else {
            accountId = Long.parseLong(tmpAccountId);
        }

        return accountId;
    }

    @Override
    public void deleteByKey(String token) {
        redisTemplate.delete(token);
    }

    public Boolean isRefreshTokenExists(String token) {
        return getValueByKey(token) != null;
    }
}
