package kr.eddi.demo.lectureClass.practiceTestCode.TestPracticeAccount.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class TestPracticeResponseForm {
    /*
       로그인 요청에 따른 응답 값은
       UUID (사용자 토큰) 이므로 Form 으로 만들어서 전달하기
    */

    final private UUID userToken;
    final private String accountRole;
}
