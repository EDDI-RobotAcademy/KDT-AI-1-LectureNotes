package com.example.demo.controller.lectureClass.vue.controller.form;

import com.example.demo.controller.lectureClass.vue.entity.Account;
import com.example.demo.controller.lectureClass.vue.entity.GameAccount;
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
