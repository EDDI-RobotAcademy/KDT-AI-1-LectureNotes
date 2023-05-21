package com.example.demo.Problem10SignIn.service.request;

import com.example.demo.Problem10SignIn.controller.form.AccountLoginResponseForm;
import com.example.demo.Problem10SignIn.entity.Account;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AccountLoginRequest {
    final private String email;
    final private String password;
    final private String uniqueRandomName;

    public AccountLoginResponseForm toAccountLoginResponseForm() {
        return new AccountLoginResponseForm(uniqueRandomName);
    }
}
