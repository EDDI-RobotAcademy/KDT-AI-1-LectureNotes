package com.example.demo.problem.account.service;

import com.example.demo.problem.account.entity.Account;
import com.example.demo.problem.account.entity.RoleType;
import com.example.demo.problem.account.service.request.AccountLoginRequest;
import com.example.demo.problem.account.service.request.AccountRegisterRequest;

public interface AccountService {
    Boolean register(AccountRegisterRequest request);

    String login(AccountLoginRequest request);

    RoleType lookup(String accountToken);

    Long findAccountId(String accountToken);
}
