package com.example.demo.exam.accountTest.controller.request.account;

import com.example.demo.exam.accountTest.entity.account.Account;
import com.example.demo.exam.accountTest.entity.RoleType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AccountRegisterRequest {

    final private String email;
    final private String password;
    final private RoleType roleType;

    public Account toAccount() {
        // Account 에 저장되있는 것은 email 과 password
        return new Account(email, password);
    }
}
