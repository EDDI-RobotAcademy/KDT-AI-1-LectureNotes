package com.example.demo.lectureClass.homework.bank4.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class LoginForm {
    final private Boolean isSuccessForLogin;
    final private Long accountId;

//    public LoginForm(Boolean isSuccessForLogin, Long accountId){
//        this.isSuccessForLogin = isSuccessForLogin;
//        this.accountId = accountId;
//    }
}
