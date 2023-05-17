package com.example.demo.problem4_6;

import com.example.demo.utility.CustomRandom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/problem4-6")
public class DicePrint {
    @GetMapping("/dice-print")
    public Integer diceNumber(){
        final int MIN = 1;
        final int MAX = 6;

        log.info("주사위를 굴리겠습니다.");

        Integer randomDiceNumber = CustomRandom.generateNumber(MIN,MAX);

        log.info("주사위는 ' "+ randomDiceNumber+ " ' 입니다.");

        return randomDiceNumber;
    }
}
