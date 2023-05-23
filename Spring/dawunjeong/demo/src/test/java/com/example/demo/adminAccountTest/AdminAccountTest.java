package com.example.demo.adminAccountTest;

import com.example.demo.lectureClass.testCode.account.controller.form.admin.TestAdminAccountRequestForm;
import com.example.demo.lectureClass.testCode.account.entity.admin.TestAdminAccount;
import com.example.demo.lectureClass.testCode.account.service.admin.TestAdminAccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AdminAccountTest {

    @Autowired
    private TestAdminAccountService testAdminAccountService;

    @Test
    @DisplayName("관리자 계정 등록하기")
    void 관리자_계정_등록하기 () {
        final String email = "admin2@test.com";
        final String password = "admin2";

        TestAdminAccountRequestForm requestForm = new TestAdminAccountRequestForm(email, password);
        TestAdminAccount adminAccount = testAdminAccountService.register(requestForm);

        assertEquals(email, adminAccount.getEmail());
        assertEquals(password, adminAccount.getPassword());
    }
}
