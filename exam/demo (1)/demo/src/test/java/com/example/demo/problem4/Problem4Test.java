package com.example.demo.problem4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo.problem4Dice.entity.Problem4Dice;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class Problem4Test {
    /*
    backlog
    Spring에서 주사위를 굴려서 결과를 알려주게 되며 vue에서는 이것을 출력하도록 구성합니다.
    스프링에서는 자동으로 굴려지는 주사위 만들기
    vue에는 버튼 하나 만들기
    vue에서 버튼을 누르면 spring에서 신호를 받아서 자동으로 굴려지고
    나온 값을 리턴하고 vue에서 alert로 알려주기

    entity 설정
        주사위 하나
    service 설정
        필요없음
    controller설정
        request 받는 곳만
    repository 설정
        필요없음
     */
    @Test
    @DisplayName("주사위를 굴립니다")
    void 주사위_값_랜덤생성 () {
        Problem4Dice dice = new Problem4Dice();

        assertTrue(dice !=null);
    }

}
