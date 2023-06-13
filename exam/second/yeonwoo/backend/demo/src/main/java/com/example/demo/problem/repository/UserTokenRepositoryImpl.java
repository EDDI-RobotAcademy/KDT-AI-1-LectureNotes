package com.example.demo.problem.repository;

import java.util.HashMap;
import java.util.Map;

public class UserTokenRepositoryImpl implements UserTokenRepository{

    private static final UserTokenRepository INSTANCE = new UserTokenRepositoryImpl();
    private final Map<String, Long> userTokenMap = new HashMap<>();

    public static UserTokenRepository getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public void save(String userToken, Long id) {
        userTokenMap.put(userToken, id);
    }

    @Override
    public Long findAccountIdByToken(String accountToken) {
        return userTokenMap.get(accountToken);
    }
}
