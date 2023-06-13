package com.example.demo.problem11.service.request;

import com.example.demo.problem11.entity.BusinessAccount;
import com.example.demo.problem11.entity.NormalAccount;
import com.example.demo.problem11.entity.RoleType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BusinessAccountRegisterRequest {

    final private String email;
    final private String password;
    final private RoleType roleType;
    final private String businessNumber;

    public BusinessAccount toBusinessAccount() {
        return new BusinessAccount(email, password, businessNumber);
    }
}
