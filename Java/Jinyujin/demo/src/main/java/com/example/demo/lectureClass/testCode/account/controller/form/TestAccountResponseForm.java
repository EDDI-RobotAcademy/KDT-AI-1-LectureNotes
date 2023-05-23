package com.example.demo.lectureClass.testCode.account.controller.form;

import com.example.demo.lectureClass.testCode.account.entity.TestAccount;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TestAccountResponseForm {

    final private Long accountId;
    final private String email;

    /*
        여기에 비밀번호 적으면 개인정보 노출 -> 찾으면 안됨!
     */
}
