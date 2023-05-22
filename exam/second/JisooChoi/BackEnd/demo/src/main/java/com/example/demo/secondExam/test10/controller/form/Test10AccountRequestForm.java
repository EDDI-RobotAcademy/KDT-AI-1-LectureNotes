package com.example.demo.secondExam.test10.controller.form;

import com.example.demo.secondExam.test10.entity.Test10Account;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Test10AccountRequestForm {

    private String email;
    private Integer password;
    private String role;
    private Integer managerRoleNum;

    public Test10Account toTest10Account() {
        return new Test10Account(email, password, role, managerRoleNum);
    }

}
