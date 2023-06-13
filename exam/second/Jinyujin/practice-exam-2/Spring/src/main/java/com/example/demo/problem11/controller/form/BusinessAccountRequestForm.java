package com.example.demo.problem11.controller.form;

import com.example.demo.problem11.entity.RoleType;
import com.example.demo.problem11.service.request.BusinessAccountRegisterRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BusinessAccountRequestForm {

    final private String email;
    final private String password;

    final private RoleType roleType;
    final private String businessNumber;

    public BusinessAccountRegisterRequest toBusinessAccountRegisterRequest() {
        return new BusinessAccountRegisterRequest(email, password, roleType, businessNumber);
    }
}
