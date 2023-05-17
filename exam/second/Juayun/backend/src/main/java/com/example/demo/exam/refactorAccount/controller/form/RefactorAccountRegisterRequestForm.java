package com.example.demo.exam.refactorAccount.controller.form;

import com.example.demo.exam.refactorAccount.entity.RoleType;
import com.example.demo.exam.refactorAccount.form.RefactorAccountRegisterRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RefactorAccountRegisterRequestForm {


    final private String email;
    final private String password;
    final private RoleType roleType;

    public RefactorAccountRegisterRequest toRefactorAccountRegisterRequest () {

        return new RefactorAccountRegisterRequest(email, password, roleType);
    }


}
