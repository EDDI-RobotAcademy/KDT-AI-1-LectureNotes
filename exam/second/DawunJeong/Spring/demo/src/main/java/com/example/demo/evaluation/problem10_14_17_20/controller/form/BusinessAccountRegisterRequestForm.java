package com.example.demo.evaluation.problem10_14_17_20.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BusinessAccountRegisterRequestForm {
    final private String email;
    final private String password;
    final private String roleType;
    final private Integer businessNumber;

}
