package com.example.demo.lectureClass.testCode.order.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TestAccountResponseForm {
    final private Long accountId;
    final private String email;
    // 이메일 정보도 보내줘야함
}
