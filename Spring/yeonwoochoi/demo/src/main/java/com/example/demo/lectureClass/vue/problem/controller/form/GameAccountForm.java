package com.example.demo.lectureClass.vue.problem.controller.form;

import com.example.demo.lectureClass.vue.problem.entity.GameAccount;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class GameAccountForm {

    final private String email;
    final private String password;

    public GameAccount toGameAccount(Long accountId) {
        return new GameAccount(accountId, email, password);
    }
}
