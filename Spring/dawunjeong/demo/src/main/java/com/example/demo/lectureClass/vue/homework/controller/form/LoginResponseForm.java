package com.example.demo.lectureClass.vue.homework.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class LoginResponseForm {
    final private Boolean isSuccessForLogin;
    final private int accountId;
}
