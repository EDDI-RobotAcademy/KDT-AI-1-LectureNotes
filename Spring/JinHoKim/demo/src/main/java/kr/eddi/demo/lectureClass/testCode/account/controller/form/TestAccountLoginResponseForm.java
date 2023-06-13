package kr.eddi.demo.lectureClass.testCode.account.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class TestAccountLoginResponseForm {

    final private UUID userToken;// 사용자 로그인 확인 식별자

    //UUID 는 Universally Unique Identifier 의 약어로, 16 바이트 길이의 128 비트 식별자입니다.
    // 이는 컴퓨터 시스템에서 객체나 엔터티를 고유하게 식별하는 데 사용됩니다

    //식별자란
    //식별자(identifier)란, 프로그래밍에서 변수, 상수, 함수, 클래스 등과 같이 사용되는 이름으로,
    // 해당 요소를 식별하는데 사용되는 이름을 말합니다.


    //"userToken"은 하나의 식별자로서, 사용자를 구별하기 위한 토큰(token)을 나타냅니다.
    // 보통 사용자 인증(authentication) 과정에서 발급되는 토큰으로, 사용자가 서버에 접근할 때 인증 정보로 사용됩니다.
    //
    //일반적으로 userToken 은 사용자가 로그인할 때 서버에서 생성하며,
    // 로그인 세션을 유지하면서 사용자가 서버에 접근할 때마다 인증 정보로 사용됩니다.
    // 이렇게 함으로써, 사용자가 인증되지 않은 요청을 보내는 것을 방지하고, 보안을 강화할 수 있습니다.
    //
    //"userToken"은 보통 문자열(String) 형태로 저장되며, 일반적으로 유효기간(expiration)과 함께 발급됩니다.
    // 유효기간이 지나면 해당 userToken 은 더 이상 유효하지 않게 되며, 사용자는 다시 로그인하여 새로운 userToken 을 발급받아야 합니다.
}