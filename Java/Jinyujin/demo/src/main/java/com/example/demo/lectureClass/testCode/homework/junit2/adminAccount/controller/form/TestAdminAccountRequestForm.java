package com.example.demo.lectureClass.testCode.homework.junit2.adminAccount.controller.form;

import com.example.demo.lectureClass.testCode.homework.junit2.adminAccount.entity.TestAdminAccount;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TestAdminAccountRequestForm {
    final private String email;
    final private String password;

    public TestAdminAccount toTestAdminAccount() {
        return new TestAdminAccount(email, password);
    }
}
