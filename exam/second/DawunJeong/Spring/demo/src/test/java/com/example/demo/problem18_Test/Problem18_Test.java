package com.example.demo.problem18_Test;

import com.example.demo.evaluation.problem10_14_17_20.controller.form.AccountLoginRequestForm;
import com.example.demo.evaluation.problem10_14_17_20.controller.form.AccountLoginResponseForm;
import com.example.demo.evaluation.problem10_14_17_20.service.AccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

// 문제 18번
@SpringBootTest
public class Problem18_Test {
    @Autowired
    private AccountService accountService;
    @Test
    @DisplayName("문제 18번 로그인하기")
    void 로그인 () {
        final String email = "normal1@test.com";
        final String password = "test";

        AccountLoginRequestForm accountLoginRequestForm = new AccountLoginRequestForm(email, password);
        AccountLoginResponseForm accountLoginResponseForm = accountService.login(accountLoginRequestForm);

        String userToken= accountLoginResponseForm.getUserToken().toString();

        assertTrue(userToken != null);
    }
}
