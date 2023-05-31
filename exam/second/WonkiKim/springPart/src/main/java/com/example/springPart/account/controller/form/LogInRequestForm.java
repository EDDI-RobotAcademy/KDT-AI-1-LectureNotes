package com.example.springPart.account.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class LogInRequestForm {
    final private String email;
    final private String password;
}
