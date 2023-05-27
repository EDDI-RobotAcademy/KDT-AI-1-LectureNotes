package com.example.demo.evaluation.problem10_14_17_20.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AccountLoginRequestForm {
    final private String email;
    final private String password;
}
