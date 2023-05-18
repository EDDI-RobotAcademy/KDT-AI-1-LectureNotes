package com.example.demo.homework.junit2;

import com.example.demo.lectureClass.testCode.homework.junit2.adminAccount.controller.form.TestAdminAccountRequestForm;
import com.example.demo.lectureClass.testCode.homework.junit2.adminAccount.entity.TestAdminAccount;
import com.example.demo.lectureClass.testCode.homework.junit2.adminAccount.service.TestAdminAccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AdminMemberTest {

    @Autowired
    private TestAdminAccountService testAdminAccountService;

    @Test
    @DisplayName("관리자 회원 가입 할 수 있음")
        // yaml: create
    void 관리자_회원이_가입한다() {
        final String email = "test@test.com";
        final String password = "test";

        TestAdminAccountRequestForm adminAccountRequestForm = new TestAdminAccountRequestForm(email, password);
        TestAdminAccount adminAccount = testAdminAccountService.register(adminAccountRequestForm);

        assertEquals(email, adminAccount.getEmail());
        assertEquals(password, adminAccount.getPassword());
    }
}
