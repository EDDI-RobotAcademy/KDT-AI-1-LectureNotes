package com.example.demo.problem.sixth.controller;

import com.example.demo.utility.random.CustomRandom;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SixthController {

    private final int MIN = 1;
    private final int MAX = 6;

    @GetMapping("/roll-dice")
    public Integer rollDice () {
        return CustomRandom.generateNumber(MIN, MAX);
    }
    // 런덤 주사위 리턴해준다.
}
