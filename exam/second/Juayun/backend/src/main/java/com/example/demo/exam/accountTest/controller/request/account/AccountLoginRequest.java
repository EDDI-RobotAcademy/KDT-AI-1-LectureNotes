package com.example.demo.exam.accountTest.controller.request.account;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AccountLoginRequest {

    final private String email;
    final private String password;
}
