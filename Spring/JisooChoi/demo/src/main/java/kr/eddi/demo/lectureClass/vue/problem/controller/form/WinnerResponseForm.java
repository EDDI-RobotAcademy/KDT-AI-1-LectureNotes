package kr.eddi.demo.lectureClass.vue.problem.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

// 부가적으로 Spring ...

@ToString
@Getter
@RequiredArgsConstructor
public class WinnerResponseForm {
    // Spring에서 데이터를 반환할 때 (json 및 form을 태울 때)
    // 아래와 같이 primitives type을 그대로 사용하면 문제가 생긴다.
    // private final int winnerNumber;
    private final Integer winnerNumber;
    private final String result;


}
