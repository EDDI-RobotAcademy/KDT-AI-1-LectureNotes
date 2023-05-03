package kr.eddi.demo.lectureClass.vue.problem4.controller.form;

import kr.eddi.demo.lectureClass.vue.problem4.game.Account;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class GameSignInForm {

    private final String loginId;
    private final String loginPw;

    public Account dataAgreementStep(boolean existAccount){
        return new Account(existAccount, loginId, loginPw);
    }

//    public Account dataAgreementStep(boolean existAccount){
//        return new Account(existAccount, loginId, loginPw);
//    }

}
