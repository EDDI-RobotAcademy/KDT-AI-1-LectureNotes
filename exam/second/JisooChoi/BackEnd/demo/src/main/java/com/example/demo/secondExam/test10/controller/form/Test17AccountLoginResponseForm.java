package com.example.demo.secondExam.test10.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class Test17AccountLoginResponseForm {
    final private UUID userToken;
    final private String role;
}
