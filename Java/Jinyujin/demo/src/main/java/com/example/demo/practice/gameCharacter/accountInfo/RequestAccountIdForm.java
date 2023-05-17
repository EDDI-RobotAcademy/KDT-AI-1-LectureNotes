package com.example.demo.practice.gameCharacter.accountInfo;

import lombok.*;

@ToString
@Getter
@NoArgsConstructor
public class RequestAccountIdForm {
    // 계정 아이디 폼을 요청하는 클래스
    // 그럼 프론트에서 받아와야 함
    // 일단 Postman으로 실험해 볼 수 있음

    private Long gameAccountId;
    // 게임 계정 아이디를 요청하기 위해서 선언해줌

    public RequestAccountIdForm(Long gameAccountId) {
        this.gameAccountId = gameAccountId;
    }
}
