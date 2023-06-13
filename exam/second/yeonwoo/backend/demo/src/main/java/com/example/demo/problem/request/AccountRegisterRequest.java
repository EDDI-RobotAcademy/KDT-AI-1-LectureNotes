package com.example.demo.problem.request;

import com.example.demo.problem.entity.Account;
import com.example.demo.problem.entity.RoleType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AccountRegisterRequest {

    final private String email;
    final private String password;
    final private RoleType roleType;

    public AccountRegisterRequest toAccountRegisterRequest () {

        return new AccountRegisterRequest(
                email, password, roleType);
    }
}
