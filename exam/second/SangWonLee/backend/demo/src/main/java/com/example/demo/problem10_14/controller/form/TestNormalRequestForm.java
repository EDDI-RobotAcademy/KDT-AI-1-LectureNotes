package com.example.demo.problem10_14.controller.form;

import com.example.demo.problem10_14.entity.TestMember;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TestNormalRequestForm {
    final private String email;
    final private String password;

    public TestMember toTestAccount(){
        return new TestMember(email, password);
    }
}
