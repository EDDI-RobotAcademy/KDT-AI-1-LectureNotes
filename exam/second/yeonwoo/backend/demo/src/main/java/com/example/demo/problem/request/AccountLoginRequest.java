package com.example.demo.problem.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.swing.*;

@Getter
@RequiredArgsConstructor
public class AccountLoginRequest {

    final private String email;
    final private String password;
}
