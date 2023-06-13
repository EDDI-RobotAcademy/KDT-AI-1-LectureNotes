package com.example.demo.problem11Test;

import com.example.demo.problems.problem11.controller.form.TestAccountRequestForm;
import com.example.demo.problems.problem11.service.TestAccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Problem11Test {
    @Autowired
    TestAccountService testAccountService;

    @Test
    @DisplayName("일반 회원 가입")
    void 일반_회원_가입 () {
        final String email = "test123456@test.com";
        final String password = "test";
        final String role = "NORMAL";
        final Long businessNumber = 0L;

        TestAccountRequestForm accountRequestForm = new TestAccountRequestForm(email, password, role, businessNumber);

        testAccountService.register(accountRequestForm);
    }

    @Test
    @DisplayName("사업자 회원 가입")
    void 사업자_회원_가입 () {
        final String email = "test@test.com";
        final String password = "test";
        final String role = "BUSINESS";
        final Long buninessNumber = 1234567890L;

        TestAccountRequestForm accountRequestForm = new TestAccountRequestForm(email, password, role, buninessNumber);

        testAccountService.register(accountRequestForm);
    }
}
