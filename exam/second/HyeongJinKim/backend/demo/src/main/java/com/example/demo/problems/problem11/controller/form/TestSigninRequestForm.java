package com.example.demo.problems.problem11.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TestSigninRequestForm {
    final private String email;
    final private String password;
}
