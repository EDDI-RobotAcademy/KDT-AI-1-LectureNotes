package com.example.demo.practice.gameCharacter.accountInfo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor // 여기선 이거 사용!
@ToString
public class GameAccount {
    // CharacterAccountForm은 처음에 계정을 입력할 때의 form이기 때문에 final을 써주어야함
    // 여기에서는 이 사람 저 사람의 계정이 모이는 것이기 때문에 final을 써주면 안된다
    // 계정들의 저장소라고 생각하면 되려나?
    // 계정 정보를 따로 관리하는 클래스라고 생각하면 된다

    private Long id;
    // 아이디니까 더 많은 값을 저장할 수 있는 Long 타입으로 으로 선언
    // long은 primitive type으로, 값이 없을 경우 0으로 초기화된다.
    // 그래서 id가 없을 때에도 0으로 세팅이 된다
    // 따라서, id가 없어서 0으로 세팅이 된 것인지, 아니면 실제 값이 0인지 데이터만 보고 판별할 수 없다.
    // 반면 Long은 wrapper type으로, 값이 없을 경우 null로 초기화 된다.
    // 따라서 값이 0이라면, id가 0으로 저장됐음을 알 수 았다.
    private String email;
    private String password;
}
