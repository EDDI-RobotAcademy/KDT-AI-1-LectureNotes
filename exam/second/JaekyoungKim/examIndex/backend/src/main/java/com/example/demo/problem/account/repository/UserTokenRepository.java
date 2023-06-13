package com.example.demo.problem.account.repository;

public interface UserTokenRepository {

    void save(String userToken, Long id);

    Long findAccountIdByToken(String accountToken);
}
