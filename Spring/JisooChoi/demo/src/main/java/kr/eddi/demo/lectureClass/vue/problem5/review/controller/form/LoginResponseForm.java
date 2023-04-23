package kr.eddi.demo.lectureClass.vue.problem5.review.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class LoginResponseForm {

    // 작업을 완료하고 정보를 전달할 때는 Response
    final private Boolean isSuccessForLogin;
    final private Long gameAccountId;
}
