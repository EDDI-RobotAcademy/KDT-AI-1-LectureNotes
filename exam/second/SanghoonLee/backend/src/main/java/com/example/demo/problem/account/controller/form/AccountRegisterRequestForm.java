package com.example.demo.problem.account.controller.form;

import com.example.demo.problem.account.entity.RoleType;
import com.example.demo.problem.account.service.request.AccountRegisterRequest;
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
