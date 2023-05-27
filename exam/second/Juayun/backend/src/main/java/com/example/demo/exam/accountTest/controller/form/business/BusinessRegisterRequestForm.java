package com.example.demo.exam.accountTest.controller.form.business;

import com.example.demo.exam.accountTest.controller.request.business.BusinessRegisterRequest;
import com.example.demo.exam.accountTest.entity.RoleType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BusinessRegisterRequestForm {

    final private String email;
    final private String password;
    final private RoleType roleType;
    final private Integer businessCode;

    public BusinessRegisterRequest toBusinessRegisterRequest() {
        return new BusinessRegisterRequest(email, password, roleType, businessCode);
    }
}
