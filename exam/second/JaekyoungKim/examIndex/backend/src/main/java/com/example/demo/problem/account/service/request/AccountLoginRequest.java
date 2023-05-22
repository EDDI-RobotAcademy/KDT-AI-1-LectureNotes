package com.example.demo.problem.account.service.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AccountLoginRequest {

    final private String email;
    final private String password;
}
