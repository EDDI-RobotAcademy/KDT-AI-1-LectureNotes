package com.example.demo.lectureClass.afterLogin.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString // 잘 넘어오나 출력해보기 위함
public class AfterLoginRequestForm {

    final private String userToken;
    final private Integer testNumber;
}
