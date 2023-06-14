package com.example.demo.Problem10SignIn.service;

import com.example.demo.Problem10SignIn.controller.form.AccountLoginRequestForm;
import com.example.demo.Problem10SignIn.controller.form.AccountLoginResponseForm;
import com.example.demo.Problem10SignIn.entity.Account;
import com.example.demo.Problem10SignIn.service.request.AccountLoginRequest;
import com.example.demo.Problem10SignIn.service.request.AccountRequest;

import java.util.UUID;

public interface AccountService {
    Boolean register(AccountRequest request);

    AccountLoginResponseForm login(AccountLoginRequest request);
}
