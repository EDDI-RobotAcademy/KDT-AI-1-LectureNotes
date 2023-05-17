package com.example.demo.lectureClass.testCode.account.controller.form.admin;

import com.example.demo.lectureClass.testCode.account.entity.admin.TestAdminAccount;
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
