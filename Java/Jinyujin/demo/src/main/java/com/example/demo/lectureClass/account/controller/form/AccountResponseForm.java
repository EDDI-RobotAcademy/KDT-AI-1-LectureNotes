package com.example.demo.lectureClass.account.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
public class AccountResponseForm {

    final private String email;

    public AccountResponseForm(String email) {
        this.email = email;
    }
}
