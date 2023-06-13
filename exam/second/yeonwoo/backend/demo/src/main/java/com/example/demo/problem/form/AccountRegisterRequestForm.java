package com.example.demo.problem.form;

import com.example.demo.problem.entity.RoleType;
import com.example.demo.problem.request.AccountLoginRequest;
import com.example.demo.problem.request.AccountRegisterRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AccountRegisterRequestForm {

    final private String email;
    final private String password;
    final private RoleType roleType;

    public AccountRegisterRequest toAccountRegisterRequest () {

        return new AccountRegisterRequest(
                email, password, roleType);
    }


}

