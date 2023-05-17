package com.example.demo.lectureClass.testCode.homework.junit2.businessAccount.controller.form;

import com.example.demo.lectureClass.testCode.homework.junit2.businessAccount.entity.TestBusinessAccount;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TestBusinessAccountRequestForm {
    final private String email;
    final private String password;

    public TestBusinessAccount toTestBusinessAccount() {
        return new TestBusinessAccount(email, password);
    }
}
