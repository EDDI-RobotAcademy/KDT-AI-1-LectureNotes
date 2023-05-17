package com.example.demo.lectureClass.vue.homework.controller.form;

import com.example.demo.lectureClass.vue.homework.charactergame.Account;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class CharacterGameAccountForm {
    final private String email;
    final private String password;

    public Account toAccount (int accountId) {
        return new Account(accountId, email, password);
    }
}
