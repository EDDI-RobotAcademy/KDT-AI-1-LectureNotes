package com.example.demo.problem10.controller.form;

import com.example.demo.problem10.entity.Member;
import com.example.demo.problem10.entity.RoleType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AccountWithRoleRequestForm {
    final private String email;
    final private String password;

    @JsonProperty("role")
    final private RoleType roleType;

    public Member toAccount() {

        return new Member(email, password);
    }
}
