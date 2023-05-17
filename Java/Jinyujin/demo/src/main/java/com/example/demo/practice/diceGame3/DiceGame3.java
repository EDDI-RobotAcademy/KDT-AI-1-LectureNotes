package com.example.demo.practice.diceGame3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/dice-game")
public class DiceGame3 {

    @GetMapping("/secondGame")
    public void DiceGame3() {
        log.info("good?"); // 통신 잘됨

        DiceGameManagerPr diceGameManagerpr = new DiceGameManagerPr(2, 3);
        // 플레이어와 주사위 개수 매개변수로 미리 넣어주기
        log.info("one more good?" + diceGameManagerpr);
        // 첫 번째 주사위 조건까지 완료

        diceGameManagerpr.applyCondition();
    }
}
