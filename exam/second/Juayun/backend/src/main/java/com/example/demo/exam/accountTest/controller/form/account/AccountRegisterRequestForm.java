package com.example.demo.exam.accountTest.controller.form.account;

import com.example.demo.exam.accountTest.controller.request.account.AccountRegisterRequest;
import com.example.demo.exam.accountTest.entity.RoleType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AccountRegisterRequestForm {

    final private String email;
    final private String password;
    final private RoleType roleType;

    public AccountRegisterRequest toAccountRegisterRequest() {
        return new AccountRegisterRequest(email, password, roleType);
    }
}
