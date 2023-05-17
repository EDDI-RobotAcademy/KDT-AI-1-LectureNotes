package com.example.demo.Problem10SignIn.service;

import com.example.demo.Problem10SignIn.service.request.AccountRequest;

public interface AccountService {
    Boolean register(AccountRequest request);

    boolean login(AccountRequest toAccountRequest);
}
