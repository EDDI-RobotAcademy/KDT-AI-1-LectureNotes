package com.example.demo.lectureClass.testCode.homework.junit2.generalAccount.controller.form;

import com.example.demo.lectureClass.testCode.homework.junit2.generalAccount.entity.TestGeneralAccount;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TestGeneralAccountRequestForm {
    final private String email;
    final private String password;

    public TestGeneralAccount toTestGeneralAccount() {
        return new TestGeneralAccount(email, password);
    }
}
