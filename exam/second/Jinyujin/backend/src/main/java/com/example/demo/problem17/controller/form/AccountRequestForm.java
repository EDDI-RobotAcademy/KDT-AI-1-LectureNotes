package com.example.demo.problem17.controller.form;

import com.example.demo.problem10.entity.Member;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AccountRequestForm {
    final private String email;
    final private String password;
}
