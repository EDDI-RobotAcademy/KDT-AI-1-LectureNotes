package com.example.demo.problem.problem11.account.controller.form;

import com.example.demo.problem.problem11.account.entity.TestAccount;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TestAccountRequestForm {

    final private String email;
    final private String password;

    public TestAccount toTestAccount() {
        return new TestAccount(email, password);
    }
}