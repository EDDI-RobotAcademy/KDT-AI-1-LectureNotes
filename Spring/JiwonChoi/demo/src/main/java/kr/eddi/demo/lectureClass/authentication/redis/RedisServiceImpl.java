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
        value.set(token, accountIdToString, Duration.ofMinutes(3));//3분후엔 로그인이 풀림
    }

    @Override
    public Long getValueByKey(String token) {
        ValueOperations<String, String> value = redisTemplate.opsForValue();
        String tmpAccountId = value.get(token); //토큰으로 id값 가져옴
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

    public Boolean isRefreshTokenExists(String token) {    //토큰이 만료됐다던가 하는 경우에 토큰refresh가 필요할 수 있음
        return getValueByKey(token) != null;
    }


    //토큰을 가지고 사용자 정보를 가져오는 작업
//    public void getAccountInfo() {
//
//    }
}
