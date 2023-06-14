package kr.eddi.demo.lectureClass.vue.problem.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class AccountLogInForm {
    final private String userEmail;
    final private String userPw;
}