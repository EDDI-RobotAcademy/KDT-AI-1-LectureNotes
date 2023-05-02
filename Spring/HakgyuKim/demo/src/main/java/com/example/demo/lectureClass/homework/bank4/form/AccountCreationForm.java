package com.example.demo.lectureClass.homework.bank4.form;

import com.example.demo.lectureClass.homework.bank4.account.Account;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@ToString
public class AccountCreationForm {
    final private String email;
    final private String password;

    public Account toAccount(Long accountId) {
        return new Account(accountId, email, password);
    }
}
