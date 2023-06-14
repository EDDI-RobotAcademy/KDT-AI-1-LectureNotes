package com.example.demo.problem.problem18.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class LoginResponseForm {

    final private Boolean isSuccessForLogin;
    final private Long accountId;
}
