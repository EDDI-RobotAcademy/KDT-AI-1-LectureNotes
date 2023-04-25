package com.example.demo.lectureClass.homework.problem.problem5.teacher;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class LoginResponseForm {
    final private boolean isSucessForLogin;
    final private long gameAccountId;


}
