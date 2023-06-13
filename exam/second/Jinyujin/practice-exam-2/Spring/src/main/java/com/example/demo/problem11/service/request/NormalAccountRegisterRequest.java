package com.example.demo.problem11.service.request;

import com.example.demo.problem11.entity.NormalAccount;
import com.example.demo.problem11.entity.Role;
import com.example.demo.problem11.entity.RoleType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class NormalAccountRegisterRequest {

    final private String email;
    final private String password;
    final private Role role;

    public NormalAccount toNormalAccount() {
        return new NormalAccount(email, password);
    }
}
