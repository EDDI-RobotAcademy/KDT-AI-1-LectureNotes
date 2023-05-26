package com.example.demo.exam.accountTest.repository;

import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
public class UserTokenRepositoryImpl implements UserTokenRepository{

    private static final UserTokenRepository INSTANCE = new UserTokenRepositoryImpl();
    private final Map<String, Long> userTokenMap = new HashMap<>();

    public static UserTokenRepository getInstance() {
        return INSTANCE;
    }

    @Override
    public void save(String userToken, Long id) {
        userTokenMap.put(userToken, id);
    }
}
