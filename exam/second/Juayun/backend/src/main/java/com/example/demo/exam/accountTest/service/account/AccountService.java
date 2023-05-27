package com.example.demo.exam.accountTest.service.account;

import com.example.demo.exam.accountTest.controller.request.account.AccountLoginRequest;
import com.example.demo.exam.accountTest.controller.request.account.AccountRegisterRequest;

public interface AccountService {
    Boolean register(AccountRegisterRequest toAccountRegisterRequest);

    String login(AccountLoginRequest toAccountLoginRequest);
}
