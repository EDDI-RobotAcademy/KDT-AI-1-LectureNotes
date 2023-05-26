package com.example.demo.test10;

import com.example.demo.test.test10.controller.form.TestAccountRequestForm;
import com.example.demo.test.test10.controller.form.TestAccountWithBusinessNumberForm;
import com.example.demo.test.test10.entity.TestAccount;
import com.example.demo.test.test10.service.TestAccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AccountTest {
    @Autowired
    private TestAccountService testAccountService;

    @Test
    @DisplayName("일반회원 회원가입")
    void 일반사용자_회원가입 () {
        final String email = "test@test.com";
        final String password = "test";
        final String role = "normal";

        TestAccountRequestForm requestForm = new TestAccountRequestForm(email, password, role);
        TestAccount account = testAccountService.register(requestForm);

        assertEquals(email, account.getEmail());
        assertEquals(password, account.getPassword());

    }

    @Test
    @DisplayName("사업자회원 회원가입")
    void 사업자회원_회원가입 () {

        final String email = "money@money.com";
        final String password = "money";
        final String role = "BUSINESS";
        final Integer businessNumber = 1234567890;

        TestAccountWithBusinessNumberForm requestForm = new TestAccountWithBusinessNumberForm(
                email, password, role, businessNumber);
        TestAccount account = testAccountService.registerWithBusinessNumber(requestForm);

        assertEquals(email, account.getEmail());
        assertEquals(password, account.getPassword());
    }
}