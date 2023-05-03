package com.example.demo.lectureClass.vue.problem.controller.form;

import com.example.demo.lectureClass.vue.problem.entity.Account;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class AccountCreationForm {

    final private String email;
    final private String password;

    public Account toAccount(Long accountId) {
        return new Account(accountId, email, password);
    }
}
