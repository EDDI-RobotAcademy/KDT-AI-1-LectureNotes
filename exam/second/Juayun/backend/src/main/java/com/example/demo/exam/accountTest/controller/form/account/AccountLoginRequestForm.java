package com.example.demo.exam.accountTest.controller.form.account;

import com.example.demo.exam.accountTest.controller.request.account.AccountLoginRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AccountLoginRequestForm {

    final private String email;
    final private String password;

    public AccountLoginRequest toAccountLoginRequest() {
        return new AccountLoginRequest(email, password);
    }
}
