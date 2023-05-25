package com.example.demo.Problem10SignIn.controller.form;

import com.example.demo.Problem10SignIn.entity.Account;
import com.example.demo.Problem10SignIn.service.request.AccountLoginRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class AccountLoginRequestForm {
    final private String email;
    final private String password;
    final private int randomInteger;

    public AccountLoginRequest toAccountLoginRequest() {
        String uniqueRandomName = "uniqueRandomName: " + UUID.randomUUID() + randomInteger;

        return new AccountLoginRequest(email, password, uniqueRandomName);
    }
}
