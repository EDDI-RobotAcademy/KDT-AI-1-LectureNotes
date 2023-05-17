package kr.eddi.demo.lectureClass.testCode.account.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TestAccountResponseForm {

    final private Long accountId;
    final private String email;
    // 비밀번호까지 넣으면 개인정보 유출이 된다.
}
