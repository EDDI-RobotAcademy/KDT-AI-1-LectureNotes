package com.example.demo.lectureClass.form;

import com.example.demo.lectureClass.entity.GameAccount;
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
