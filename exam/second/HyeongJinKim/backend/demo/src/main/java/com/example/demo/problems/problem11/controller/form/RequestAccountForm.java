package com.example.demo.problems.problem11.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class RequestAccountForm {

    final private String email;
    final private String password;
    final private String role;
    final private Long businessNumber;
}
