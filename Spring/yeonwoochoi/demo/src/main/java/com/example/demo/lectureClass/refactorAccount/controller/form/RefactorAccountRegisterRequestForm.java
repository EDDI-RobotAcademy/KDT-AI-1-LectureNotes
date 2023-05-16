package com.example.demo.lectureClass.refactorAccount.controller.form;

import com.example.demo.lectureClass.refactorAccount.entity.RoleType;
import com.example.demo.lectureClass.refactorAccount.service.request.RefactorAccountRegisterRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RefactorAccountRegisterRequestForm {

    final private String email;
    final private String password;
    final private RoleType roleType;

    public RefactorAccountRegisterRequest toRefactorAccountRegisterRequest () {

        return new RefactorAccountRegisterRequest(
                email, password, roleType);
    }
}