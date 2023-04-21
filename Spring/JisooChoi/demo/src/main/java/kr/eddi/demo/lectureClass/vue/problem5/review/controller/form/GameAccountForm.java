package kr.eddi.demo.lectureClass.vue.problem5.review.controller.form;

import kr.eddi.demo.lectureClass.vue.problem5.review.entity.GameAccount;
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