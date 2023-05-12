package com.example.demo.lectureClass.testCode.account.controller.form.account;

import com.example.demo.lectureClass.testCode.account.entity.account.TestAccount;
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
