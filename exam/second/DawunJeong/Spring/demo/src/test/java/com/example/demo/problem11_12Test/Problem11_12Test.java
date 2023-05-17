package com.example.demo.problem11_12Test;

import com.example.demo.evaluation.problem10_14_17_20.controller.form.BusinessAccountRegisterRequestForm;
import com.example.demo.evaluation.problem10_14_17_20.controller.form.NormalAccountRegisterRequestForm;
import com.example.demo.evaluation.problem10_14_17_20.entity.Account;
import com.example.demo.evaluation.problem10_14_17_20.service.AccountService;
import com.example.demo.evaluation.problem10_14_17_20.service.request.BusinessAccountRegisterRequest;
import com.example.demo.evaluation.problem10_14_17_20.service.request.NormalAccountRegisterRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// 문제 11 ~ 12번
@SpringBootTest
public class Problem11_12Test {

    @Autowired
    private AccountService accountService;

    @Test
    @DisplayName("문제 11번. 일반 회원 가입 하기")
    void 일반_회원_가입_하기 () {
        final String email = "normal1@test.com";
        final String password = "test";
        final String roleType = "NORMAL";

        NormalAccountRegisterRequestForm normalAccountRegisterRequestForm =
                new NormalAccountRegisterRequestForm(email, password, roleType);

        NormalAccountRegisterRequest normalAccountRegisterRequest =
                new NormalAccountRegisterRequest(
                        normalAccountRegisterRequestForm.getEmail(),
                        normalAccountRegisterRequestForm.getPassword(),
                        normalAccountRegisterRequestForm.getRoleType()
                );

        Account account = accountService.normalRegister(normalAccountRegisterRequest);

        assertEquals(email, account.getEmail());
    }
    @Test
    @DisplayName("문제 12번. 사업자 회원 가입 하기")
    void 사업자_회원_가입_하기 () {
        final String email = "business@test.com";
        final String password = "test";
        final String roleType = "BUSINESS";
        final Integer businessNumber = 1223334444;

        BusinessAccountRegisterRequestForm accountRegisterRequestForm =
                new BusinessAccountRegisterRequestForm(email, password, roleType, businessNumber);

        BusinessAccountRegisterRequest accountRegisterRequest =
                new BusinessAccountRegisterRequest(
                        accountRegisterRequestForm.getEmail(),
                        accountRegisterRequestForm.getPassword(),
                        accountRegisterRequestForm.getRoleType(),
                        accountRegisterRequestForm.getBusinessNumber()
                );

        Account account = accountService.businessRegister(accountRegisterRequest);

        assertEquals(email, account.getEmail());
    }

}
