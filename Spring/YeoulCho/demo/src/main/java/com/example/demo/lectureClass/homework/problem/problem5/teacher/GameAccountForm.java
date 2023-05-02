package com.example.demo.lectureClass.homework.problem.problem5.teacher;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class GameAccountForm {

    final private String email;
    final private String password;

    public GameAccount toGameAccount(long accountId) {
        return new GameAccount(accountId,email,password);
    }
}