package kr.eddi.demo.vue.problem.Controller.form;


import kr.eddi.demo.vue.problem.entity.GameAccount;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class GameAccountForm {

    final private String email;
    final private String password;
// 받아온 정보로 어카운트 생성하는 매서드
    public GameAccount toGameAccount(Long accountId) {
        return new GameAccount(accountId, email, password);
    }
}
