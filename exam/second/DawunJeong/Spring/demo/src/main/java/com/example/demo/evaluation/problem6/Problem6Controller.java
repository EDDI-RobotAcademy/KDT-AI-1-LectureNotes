package com.example.demo.evaluation.problem6;

// 문제 6번
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.demo.evaluation.utility.random.CustomRandom.generateNumber;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/problem5")
public class Problem6Controller {
    @GetMapping("/rolldice")
    public Integer rollDice () {
        log.info("rollDice()");
        final int MIN = 1;
        final int MAX = 6;

        final int resultDiceNumber = generateNumber(MIN, MAX);

        return resultDiceNumber;
    }
}
