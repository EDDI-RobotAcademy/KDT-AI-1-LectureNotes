package com.example.demo.exam.exam10To30.account.service.request;

import com.example.demo.exam.exam10To30.account.entity.Account;
import com.example.demo.exam.exam10To30.account.entity.RoleType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AccountRegisterRequest {

    final private String email;
    final private String password;
    final private RoleType roleType;
    final private String businessNumber;

    public Account toAccount () {

        return new Account(email, password);
    }

}
