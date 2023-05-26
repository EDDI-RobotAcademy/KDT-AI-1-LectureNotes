package com.example.demo.exam.exam10To30.account.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class LoginRequestForm {

    final private String email;
    final private String password;
}
