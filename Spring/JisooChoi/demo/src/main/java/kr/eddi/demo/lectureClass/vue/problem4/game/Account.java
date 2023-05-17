package kr.eddi.demo.lectureClass.vue.problem4.game;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Account {

    // 계정 존재 여부
    private boolean existAccount;

    // 계정 아이디와 비밀번호
    private final String accountId;
    private final String accountPw;

    public void setExistAccount(boolean existAccount) {
        this.existAccount = existAccount;
    }
}
