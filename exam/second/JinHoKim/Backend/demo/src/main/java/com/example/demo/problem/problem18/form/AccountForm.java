package com.example.demo.problem.problem18.form;

import com.example.demo.problem.problem18.entity.Account;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class AccountForm {

    final private String email;
    final private String password;

    public Account toAccount(Long accountId) {
        return new Account(accountId, email, password);
    }
}