package com.example.demo.problems.problem5;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("dice-game")
public class Problem5Controller {
    final private int MIN = 1;
    final private int MAX = 6;

    public static int generateNumber (int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    @GetMapping("rollDice")
    public Integer randomDice () {
        return generateNumber(MIN, MAX);
    }
}
