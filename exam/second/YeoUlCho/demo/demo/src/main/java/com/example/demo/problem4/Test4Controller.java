package com.example.demo.problem4;

import com.example.demo.random.CustomRandom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/game")
public class Test4Controller {
    //주사위 숫자를 전달하자
    //        SucessCriteria:
    //        1. Controller 생성하여서 정보를 보낼 수 있게 하자
    //        2. 랜덤한 주사위 숫자나오게 만들기
    //        3. vue에게 주사위 정보를 전달
    //        To-do:
    //        1. Controller 생성
    //        2. 랜덤 주사위 메서드 작성
    @GetMapping("/dice")
    public int diceNumber(){
        final int diceNumber = CustomRandom.generateNumber(6,0);
        return diceNumber;
    }
}
