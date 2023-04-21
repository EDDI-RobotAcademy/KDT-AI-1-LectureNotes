package com.example.demo.controller.lectureClass.vue.controller.form;

import com.example.demo.controller.lectureClass.vue.entity.Account;
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
        // accountId 계정의 갯수
        return new Account(accountId, email, password);
    }
}
