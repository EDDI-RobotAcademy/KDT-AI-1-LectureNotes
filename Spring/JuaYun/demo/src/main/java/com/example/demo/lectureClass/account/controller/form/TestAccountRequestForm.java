package com.example.demo.lectureClass.account.controller.form;

import com.example.demo.lectureClass.account.entity.TestAccount;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TestAccountRequestForm {

    final private String email;
    final private String password;

    public TestAccount toTestAccount() {
        return new TestAccount(email,password);
    }
}
