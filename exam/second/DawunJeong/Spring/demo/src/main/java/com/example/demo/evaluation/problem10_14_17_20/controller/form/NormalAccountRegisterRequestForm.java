package com.example.demo.evaluation.problem10_14_17_20.controller.form;

import com.example.demo.evaluation.problem10_14_17_20.entity.Account;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class NormalAccountRegisterRequestForm {
    final private String email;
    final private String password;
    final private String roleType;

    public Account toAccount () {
        return new Account(email, password);
    }
}
