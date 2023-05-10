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
    // true인 애들 UUID.randomUUId()로 바꾸기

    // UUID란?
    // 각 개체를 고유하게 식별할 수 있게 해주는 값
    // 지금은 사이즈가 작아서 뭐가 뭔지 구별하기 쉽지만
    // 사이즈가 커질수록 결국 중복이 발생한다
    // UUID가 그것을 최대로 방지해 줄 수 있는 것

    // UUID는 UUID.randomUUId()로 UUID값을 생성하는 것
    // 변수이름만 다르게 똑같이 UUID.randomUUId()로 아무리 많이 생성해도
    // 다 다른 값으로 생성됨!
    // 일단 여기서는 UUID 타입의 userToken이라는 변수명을 생성해뒀고

}
