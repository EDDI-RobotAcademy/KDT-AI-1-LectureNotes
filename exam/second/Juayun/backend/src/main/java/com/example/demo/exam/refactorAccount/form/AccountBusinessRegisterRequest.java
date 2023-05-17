package com.example.demo.exam.refactorAccount.form;

import com.example.demo.exam.refactorAccount.entity.AccountBusiness;
import com.example.demo.exam.refactorAccount.entity.RoleType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AccountBusinessRegisterRequest {
    final private String email;
    final private String password;
    final private Float BUSINESS_NUMBER;
    final private RoleType roleType;

    public AccountBusiness toAccountBusiness() {
        return new AccountBusiness(email, password, BUSINESS_NUMBER);
    }
}
