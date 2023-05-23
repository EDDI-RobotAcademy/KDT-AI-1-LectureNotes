package com.example.demo.twelveth;

import com.example.demo.problem.account.controller.form.AccountRegisterRequestForm;
import com.example.demo.problem.account.entity.RoleType;
import com.example.demo.problem.account.service.AccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.demo.problem.account.entity.RoleType.BUSINESS;
import static com.example.demo.problem.account.entity.RoleType.NORMAL;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TwelvethProblemTest {

    @Autowired
    private AccountService accountService;

    @Test
    @DisplayName("사업자 가입")
    void 사업자_가입하기 () {
        final String email = "test@gmail.com";
        final String password = "test";
        final RoleType role = BUSINESS;

        AccountRegisterRequestForm requestForm =
                new AccountRegisterRequestForm(email, password, role);

        Boolean isSuccess = accountService.register(
                requestForm.toAccountRegisterRequest());

        assertTrue(isSuccess);
    }

    @Test
    @DisplayName("중복된 이메일 회원가입 방지")
    void 중복된_이메일_회원가입_방지 () {
        final String email = "test@test.com";
        final String password = "test";
        final RoleType role = NORMAL;

        AccountRegisterRequestForm requestForm =
                new AccountRegisterRequestForm(email, password, role);

        Boolean isSuccess = accountService.register(
                requestForm.toAccountRegisterRequest());

        assertFalse(isSuccess);
    }
}
