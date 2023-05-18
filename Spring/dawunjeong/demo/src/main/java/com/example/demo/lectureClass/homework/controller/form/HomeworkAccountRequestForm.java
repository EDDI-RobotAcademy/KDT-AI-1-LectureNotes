package com.example.demo.lectureClass.homework.controller.form;

import com.example.demo.lectureClass.homework.entity.HomeworkAccount;
import com.example.demo.lectureClass.homework.entity.RoleType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class HomeworkAccountRequestForm {
    final private String email;
    final private String password;

    @JsonProperty("role")
    final private RoleType roleType;

    public HomeworkAccount toHomeworkAccount() {
        return new HomeworkAccount(email, password);
    }

}
