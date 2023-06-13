package com.example.demo.lectureClass.afterLogin.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class AfterLoginRequestForm {

    final private String userToken;
    final private Integer testNumber;

}
