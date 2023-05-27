package com.example.demo.problem.service;

import com.example.demo.problem.entity.RoleType;
import com.example.demo.problem.request.AccountLoginRequest;
import com.example.demo.problem.request.AccountRegisterRequest;

public interface AccountService {
    Boolean register(AccountRegisterRequest request);

    String login(AccountLoginRequest request);

    RoleType lookup(String accountToken);
}
