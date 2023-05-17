package com.example.demo.problem18Test;

import com.example.demo.problems.problem11.controller.form.TestSigninRequestForm;
import com.example.demo.problems.problem11.service.TestAccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Problem18Test {
    @Autowired
    TestAccountService testAccountService;

    @Test
    @DisplayName("로그인")
    void 로그인 () {
        final String email = "test6@test.com";
        final String password = "test";

        TestSigninRequestForm signinRequestForm = new TestSigninRequestForm(email, password);

        testAccountService.signin(signinRequestForm);
    }
}
