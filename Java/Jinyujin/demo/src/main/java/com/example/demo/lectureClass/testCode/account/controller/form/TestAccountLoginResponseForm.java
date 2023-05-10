package com.example.demo.lectureClass.testCode.account.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@Getter
public class TestAccountLoginResponseForm {

//    final private Boolean isLogin;
    final private UUID userToken;
    // 구분하기 위한 것
    // 두개를 다 남길 필요 없음
    // 불리언 사라졌으니 서비스 임플에서 false인 애들 null로
    // true인 애들 UUID로 바꾸기
}
