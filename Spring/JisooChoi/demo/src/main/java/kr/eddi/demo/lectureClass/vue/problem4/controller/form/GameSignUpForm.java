package kr.eddi.demo.lectureClass.vue.problem4.controller.form;

import kr.eddi.demo.lectureClass.vue.problem4.game.Member;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class GameSignUpForm {

    private final String userId;
    private final String userPw;

    public Member memberListAddInfo(Long memberId){
        return new Member(memberId,userId, userPw);
    }
}
