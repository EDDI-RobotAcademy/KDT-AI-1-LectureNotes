package com.example.demo.evaluation.problem10_14_17_20.service.request;

import com.example.demo.evaluation.problem10_14_17_20.entity.RoleType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BusinessAccountRegisterRequest {
    final private String email;
    final private String password;
    final private RoleType roleType;
    final private Integer businessNumber;

    public BusinessAccountRegisterRequest(String email, String password, String roleType, Integer businessNumber) {
        this.email = email;
        this.password = password;
        this.roleType = RoleType.valueOf(roleType);
        this.businessNumber = businessNumber;
    }
}
