package com.example.demo.homework;

import com.example.demo.lectureClass.utility.random.CustomRandom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/vue-homework")
public class VueHomework1 {
    @GetMapping("/roll-two-dice") // 그냥 달라고 요청하는 거니까 파라메터 필요 없음
    public String getRandomDice() {
        final int MIN = 1;
        final int MAX = 6;
        final int EVEN_DECISION = 2;

        int firstDiceNumber = CustomRandom.generateNumber(MIN,MAX);
        int secondDiceNumber = CustomRandom.generateNumber(MIN,MAX);

        int diceSum = firstDiceNumber + secondDiceNumber;

        if (diceSum % EVEN_DECISION == 0) {
            return "첫 번째 주사위 값: " + firstDiceNumber + '\n' +
                    "두 번째 주사위 값: " + secondDiceNumber + '\n' +
                    "주사위 합: " + diceSum + '\n' +
                    "축하합니다.승리!";
        } else {
            return "첫 번째 주사위 값: " + firstDiceNumber + '\n' +
                    "두 번째 주사위 값: " + secondDiceNumber + '\n' +
                    "주사위 합: " + diceSum + '\n' +
                    "패배!";
        }

    }
}
