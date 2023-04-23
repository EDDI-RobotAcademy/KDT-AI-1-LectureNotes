package kr.eddi.demo.lectureClass.vue.problem5.review.controller.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class RequestAccountIdForm {

    // 받아온 정보를 작업하고 싶을 때는 Request

    // 현재 여기로 로그인 한 사용자의 숫자가 들어온다.
    private Long gameAccountId;

    public RequestAccountIdForm(Long gameAccountId) {
        this.gameAccountId = gameAccountId;
    }
}
