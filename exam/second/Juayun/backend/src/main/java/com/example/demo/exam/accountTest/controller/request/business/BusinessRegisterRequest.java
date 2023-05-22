package com.example.demo.exam.accountTest.controller.request.business;

import com.example.demo.exam.accountTest.entity.RoleType;
import com.example.demo.exam.accountTest.entity.business.BusinessAccount;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BusinessRegisterRequest {

    final private String email;
    final private String password;
    final private RoleType roleType;
    final private Integer businessCode;

    public BusinessAccount toBusinessAccount() {
        return new BusinessAccount(email, password, businessCode);
    }
}
