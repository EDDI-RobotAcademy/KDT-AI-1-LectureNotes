package com.example.demo.lectureClass.homework.problem.problem5;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@Getter

public class LoginResponseForm {
    final private String userEmail;

    public LoginResponseForm(String userEmail) {
        this.userEmail = userEmail;
    }
}
