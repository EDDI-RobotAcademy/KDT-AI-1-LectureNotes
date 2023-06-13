package com.example.demo.login;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class LoginForm {
    final private String email;
    final private String password;
}
