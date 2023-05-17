package com.example.demo.lectureClass.testCode.order.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TestOrderAccountRequestForm {

    final private Long productId;
    // 원래라면 유저토큰이 있어야함 관리자만 봐야하니까
}
