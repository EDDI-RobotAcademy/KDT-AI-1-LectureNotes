package com.example.demo.eighteenth;

import com.example.demo.problem.account.controller.form.AccountLoginRequestForm;
import com.example.demo.problem.account.controller.form.AccountRegisterRequestForm;
import com.example.demo.problem.account.entity.RoleType;
import com.example.demo.problem.account.service.AccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.demo.problem.account.entity.RoleType.NORMAL;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class EighteenthProblemTest {

    @Autowired
    private AccountService accountService;

    @Test
    @DisplayName("로그인 해보기")
    void 로그인_진행 () {
        final String email = "test@test.com";
        final String password = "test";

        AccountLoginRequestForm requestForm =
                new AccountLoginRequestForm(email, password);

        String userToken = accountService.login(requestForm.toAccountLoginRequest());

        assertTrue(userToken != null);
    }
}
