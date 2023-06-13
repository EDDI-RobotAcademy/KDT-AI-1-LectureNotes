package com.example.demo.exam.dice;

import com.example.demo.custom.CustomRandom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/dice-game")
public class DiceController {

    /*
        4번 문제

        주사위 굴리기 요청을 받으면 랜덤한 주사위를 굴려 결과값 반환하기

        Success Criteria
        - 정보를 보내줄 controller 를 만들어서 주사위값을 요청받으면 랜덤한 값을 출력하여 반환하기

        To-Do
        - controller 페이지를 만들고 랜덤값 출력하기
        - 요청된 값을 반환하기
     */
    @GetMapping("/random")
    public Integer getRandomDice () {
        final int MIN = 1;
        final int MAX = 6;

        log.info("getRandomDice() 요청!");
        int winnerNumber = CustomRandom.generateNumber(MIN, MAX);

        return winnerNumber;
    }
}
