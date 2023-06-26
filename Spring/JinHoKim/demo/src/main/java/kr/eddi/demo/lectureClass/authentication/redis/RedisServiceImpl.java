package kr.eddi.demo.lectureClass.authentication.redis;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Slf4j
@Service
@RequiredArgsConstructor
public class RedisServiceImpl implements RedisService {

    final private StringRedisTemplate redisTemplate;

    @Override
    public void setKeyAndValue(String token, Long accountId) {
        String accountIdToString = String.valueOf(accountId);
        ValueOperations<String, String> value = redisTemplate.opsForValue();
        value.set(token, accountIdToString, Duration.ofMinutes(3));
    }

    @Override
    public Long getValueByKey(String token) {
        ValueOperations<String, String> value = redisTemplate.opsForValue();
        String tmpAccountId = value.get(token);
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
