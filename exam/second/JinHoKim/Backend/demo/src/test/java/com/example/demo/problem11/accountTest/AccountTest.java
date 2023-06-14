package com.example.demo.problem11.accountTest;

import com.example.demo.problem.problem11.account.controller.form.TestAccountWithRoleRequestForm;
import com.example.demo.problem.problem11.account.entity.TestAccount;
import com.example.demo.problem.problem11.account.repository.TestAccountRepository;
import com.example.demo.problem.problem11.account.service.TestAccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AccountTest {

    @Autowired
    private TestAccountService testAccountService;

    @Autowired
    private TestAccountRepository testAccountRepository;

    @Test
    @DisplayName("회원가입을 합니다(일반회원)")
    void 일반회원_회원가입 () {

        final String email = "gogo@gogo.com";
        final String password = "gogo";
        final String role = "NORMAL";

        TestAccountWithRoleRequestForm requestForm = new TestAccountWithRoleRequestForm(email, password, role);
        TestAccount account = testAccountService.registerWithRole(requestForm);

        assertEquals(email, account.getEmail());
        assertEquals(password, account.getPassword());
    }

    @Test
    @DisplayName("회원가입을 합니다(사업자)")
    void 사업자_회원가입 () {
        final String email = "business@test.com";
        final String password = "test";
        final String role = "BUSINESS";

        TestAccountWithRoleRequestForm requestForm = new TestAccountWithRoleRequestForm(email, password, role);
        TestAccount account = testAccountService.registerWithRole(requestForm);

        assertEquals(email, account.getEmail());
        assertEquals(password, account.getPassword());
    }


}