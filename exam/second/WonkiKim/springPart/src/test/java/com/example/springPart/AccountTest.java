package com.example.springPart;

import com.example.springPart.account.controller.form.LogInRequestForm;
import com.example.springPart.account.controller.form.SignUpRequestForm;
import com.example.springPart.account.entity.Account;
import com.example.springPart.account.service.AccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AccountTest {
    @Autowired
    private AccountService accountService;

    @Test
    @DisplayName("일반회원이 회원가입합니다.")
    void 일반회원_회원가입() {
        final String email = "test@normal.com";
        final String password = "1234";
        final String role = "NORMAL";
        final String businessNumber = null;

        SignUpRequestForm reqForm = new SignUpRequestForm(email,password, role, businessNumber);
        Account cretedAccount = accountService.signUp(reqForm);

        assertEquals(1L, cretedAccount.getId());
        assertEquals( null, cretedAccount.getBusinessNumber());
        assertEquals(email, cretedAccount.getEmail());
        assertEquals(password, cretedAccount.getPassword());
        assertEquals(role, cretedAccount.getRole());
    }

    @Test
    @DisplayName("사업자회원이 회원가입합니다.")
    void 사업자_회원가입() {
        final String email = "test@business.com";
        final String password = "1234";
        final String role = "BUSINESS";
        final String businessNumber = "1234567890";

        SignUpRequestForm reqForm = new SignUpRequestForm(email,password, role, businessNumber);
        Account cretedAccount = accountService.signUp(reqForm);

        assertEquals(2L, cretedAccount.getId());
        assertEquals( "1234567890", cretedAccount.getBusinessNumber());
        assertEquals(email, cretedAccount.getEmail());
        assertEquals(password, cretedAccount.getPassword());
        assertEquals(role, cretedAccount.getRole());
    }

    @Test
    @DisplayName("일반회원이 로그인합니다")
    void 일반회원_로그인() {
        final String email = "test@normal.com";
        final String password = "1234";

        LogInRequestForm requestForm = new LogInRequestForm(email, password);
        Account logInAccount = accountService.logIn(requestForm);

        assertEquals(email, logInAccount.getEmail());
        assertEquals(password, logInAccount.getPassword());
        assertEquals(1L, logInAccount.getId());
    }

    @Test
    @DisplayName("사업자회원이 로그인합니다")
    void 사업자_로그인() {
        final String email = "test@business.com";
        final String password = "1234";

        LogInRequestForm requestForm = new LogInRequestForm(email, password);
        Account logInAccount = accountService.logIn(requestForm);

        assertEquals(email, logInAccount.getEmail());
        assertEquals(password, logInAccount.getPassword());
        assertEquals(2L, logInAccount.getId());
    }
}
