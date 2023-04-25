package com.example.demo.lectureClass.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class LoginResponseForm {
    final private Boolean isSuccessForLogin;
    final private Long gameAccountId;

}
