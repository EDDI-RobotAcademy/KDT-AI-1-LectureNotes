package com.example.demo.practice.gameCharacter.accountInfo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@RequiredArgsConstructor
public class GameAccountForm {
    // 여기는 처음에 계정을 입력할 때의 form이기 때문에 final을 써주어야함
    // Account 클래스에서는 이 사람 저 사람의 계정이 모이는 것이기 때문에
    // final을 써주면 안된다
    final private String email;
    final private String password;

    public GameAccount toAccount(Long accountId) {

        return new GameAccount(accountId, email, password);
    } // 이렇게 리턴하는 방법도 있구나
}
