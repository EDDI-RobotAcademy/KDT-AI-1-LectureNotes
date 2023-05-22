package com.example.demo.exam.accountTest.controller.request.business;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BusinessLoginRequest {

    final private String email;
    final private String password;
    final private Integer businessCode;
}
