package com.example.demo.evaluation.problem10_14_17_20.service.request;

import com.example.demo.evaluation.problem10_14_17_20.entity.RoleType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class NormalAccountRegisterRequest {
    final private String email;
    final private String password;
    final private RoleType roleType;

    public NormalAccountRegisterRequest(String email, String password, String roleType) {
        this.email = email;
        this.password = password;
        this.roleType = RoleType.valueOf(roleType);
    }
}
