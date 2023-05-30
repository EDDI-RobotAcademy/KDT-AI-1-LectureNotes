package com.example.demo.accountTest;

import com.example.demo.exam.accountTest.controller.form.account.AccountLoginRequestForm;
import com.example.demo.exam.accountTest.controller.form.account.AccountRegisterRequestForm;
import com.example.demo.exam.accountTest.controller.form.business.BusinessLoginRequestForm;
import com.example.demo.exam.accountTest.controller.form.business.BusinessRegisterRequestForm;
import com.example.demo.exam.accountTest.entity.RoleType;
import com.example.demo.exam.accountTest.service.account.AccountService;
import com.example.demo.exam.accountTest.service.business.BusinessService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.demo.exam.accountTest.entity.RoleType.BUSINESS;
import static com.example.demo.exam.accountTest.entity.RoleType.NORMAL;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class AccountTest {

    @Autowired
    private AccountService accountService;

    @Autowired
    private BusinessService businessService;

    @Test
    @DisplayName("일반 회원 가입")
    void 일반_회원_가입 () {
        final String email = "test@test.com";
        final String password = "test";
        final RoleType roleType = NORMAL;

        AccountRegisterRequestForm requestForm =
                new AccountRegisterRequestForm(email, password, roleType);
        Boolean isSuccess = accountService.register(requestForm.toAccountRegisterRequest());

        assertTrue(isSuccess);
    }

    @Test
    @DisplayName("일반 회원 로그인")
    void 일반_회원_로그인 () {
        final String email = "test@test.com";
        final String password = "test";

        AccountLoginRequestForm requestForm = new AccountLoginRequestForm(email, password);
        String userToken = accountService.login(requestForm.toAccountLoginRequest());

        assertTrue(userToken != null);

    }

    @Test
    @DisplayName("사업자 회원 가입")
    void 사업자_회원_가입 () {
        final String email = "business@test.com";
        final String password = "business";
        final RoleType roleType = BUSINESS;
        final Integer businessCode = 111-11-11111;

        BusinessRegisterRequestForm requestForm = new
                BusinessRegisterRequestForm(email, password, roleType, businessCode);
        Boolean isSuccess = businessService.register(requestForm.toBusinessRegisterRequest());

        assertTrue(isSuccess);
    }

    @Test
    @DisplayName("사업자 회원 로그인")
    void 사업자_회원_로그인 () {
        final String email = "business@test.com";
        final String password = "business";
        final Integer businessCode = 111-11-11111;

        BusinessLoginRequestForm requestForm = new BusinessLoginRequestForm(email, password, businessCode);
        String userToken = businessService.login(requestForm.toBusinessLoginRequest());

        assertTrue(userToken != null);
    }

}
