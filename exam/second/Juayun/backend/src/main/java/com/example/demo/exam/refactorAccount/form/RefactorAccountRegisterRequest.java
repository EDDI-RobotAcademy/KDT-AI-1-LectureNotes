package com.example.demo.exam.refactorAccount.form;

import com.example.demo.exam.refactorAccount.entity.RefactorAccount;
import com.example.demo.exam.refactorAccount.entity.RoleType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RefactorAccountRegisterRequest {

    final private String email;
    final private String password;
    final private RoleType roleType;


    public RefactorAccount toRefactorAccount() {
        return new RefactorAccount(email, password);
    }
}
