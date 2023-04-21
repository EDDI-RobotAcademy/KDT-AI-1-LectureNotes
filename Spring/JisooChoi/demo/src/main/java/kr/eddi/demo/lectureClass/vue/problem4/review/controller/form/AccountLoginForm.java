package kr.eddi.demo.lectureClass.vue.problem4.review.controller.form;

import kr.eddi.demo.lectureClass.vue.problem4.review.entity.Account;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class AccountLoginForm {

    final private String loginUserEmail;
    final private String userPw;
}
