package com.example.demo.controller.lectureClass.vue.problem.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

// 부가적으로 spring 에서 RestController 로 데이터를 반환할 때
// 내장 라이브러리들이 객체의 정보를 재조합하게 됩니다.
// 이 상황에서 Getter가 필요한데 누락되면 데이터 전송이 안도비니다.
@Getter
@RequiredArgsConstructor
@ToString
public class WinnerResponseForm {
    // spring 에서 데이터를 반환할 때 (json 및 form 을 태울 때)
    // 아래와 같이 primitives type 을 그대로 사용하면 문제가 됩니다.
    // private final int winnerNumber; 죽임
    private final Integer winnerNumber;
    private final String result;


}
