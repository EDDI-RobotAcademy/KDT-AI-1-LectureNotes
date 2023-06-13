package com.example.demo.exam.accountTest.controller.form.business;

import com.example.demo.exam.accountTest.controller.request.business.BusinessLoginRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BusinessLoginRequestForm {

    final private String email;
    final private String password;
    final private Integer businessCode;


    public BusinessLoginRequest toBusinessLoginRequest() {
        return new BusinessLoginRequest(email, password, businessCode);
    }
}
