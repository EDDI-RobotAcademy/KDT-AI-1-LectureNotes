package com.example.demo.exam.refactorAccount.controller.form;

import com.example.demo.exam.refactorAccount.entity.RoleType;
import com.example.demo.exam.refactorAccount.form.AccountBusinessRegisterRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AccountBusinessRegisterRequestForm {

    final private String email;
    final private String password;
    final private Float BUSINESS_NUMBER;
    final private RoleType roleType;

    public AccountBusinessRegisterRequest toAccountBusinessRegisterRequest() {

        return new AccountBusinessRegisterRequest(email, password, BUSINESS_NUMBER, roleType);
    }
}
