package com.example.demo.problems.problem11.controller.form;

import com.example.demo.problems.problem11.entity.TestAccount;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TestAccountRequestForm {

    final private String email;
    final private String password;
    final private String role;
    final private Long businessNumber;

    public TestAccount toTestAccount() {
        return new TestAccount(email, password, role, businessNumber);
    }
}
