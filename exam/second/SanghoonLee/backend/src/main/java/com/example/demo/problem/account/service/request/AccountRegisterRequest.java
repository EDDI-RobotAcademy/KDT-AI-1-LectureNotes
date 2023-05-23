package com.example.demo.problem.account.service.request;

import com.example.demo.problem.account.entity.Account;
import com.example.demo.problem.account.entity.RoleType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AccountRegisterRequest {

    final private String email;
    final private String password;
    final private RoleType roleType;

    public Account toAccount () {
        return new Account(email, password);
    }
}
