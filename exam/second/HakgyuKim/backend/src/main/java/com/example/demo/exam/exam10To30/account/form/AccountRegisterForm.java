package com.example.demo.exam.exam10To30.account.form;

import com.example.demo.exam.exam10To30.account.entity.RoleType;
import com.example.demo.exam.exam10To30.account.service.request.AccountRegisterRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AccountRegisterForm {

    final private String email;
    final private String password;

    @JsonProperty("role")
    final private RoleType roleType;

    final private String businessNumber;

    public AccountRegisterRequest toAccountRegisterRequest () {

        return new AccountRegisterRequest(email, password, roleType, businessNumber);
    }
}
