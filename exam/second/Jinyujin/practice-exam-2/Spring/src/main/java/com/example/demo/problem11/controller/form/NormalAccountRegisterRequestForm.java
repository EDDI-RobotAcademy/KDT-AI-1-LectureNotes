package com.example.demo.problem11.controller.form;

import com.example.demo.problem11.entity.RoleType;
import com.example.demo.problem11.service.request.NormalAccountRegisterRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class NormalAccountRegisterRequestForm {

    final private String email;
    final private String password;

    final private RoleType roleType;

    public NormalAccountRegisterRequest toAccountRegisterRequest () {

        return new NormalAccountRegisterRequest(
                email, password, roleType);
    }
}
