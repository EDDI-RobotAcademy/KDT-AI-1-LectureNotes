package com.example.demo.problem6;

import com.example.demo.utility.random.CustomRandom;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dice")
public class DiceController {

    // 주사위 굴리기 요청이 들어오면 랜덤 값을 생성해 전달합니다 [SDP-1]
    // Susccess Criteria
    // 1. front로부터 주사위 굴리기 요청을 받습니다
    // 2. 1에서 6사이의 랜덤한 숫자를 생성합니다
    // 3. 생성한 랜덤한 숫자를 front로 전달합니다
    // To-Do
    // 1. 요청을 받을 Controller 생성
    // 2. 랜덤 숫자 생성 메서드 작성

    @GetMapping("get-dice")
    public Integer getDice(){
        final int MIN = 1;
        final int MAX = 6;

        return CustomRandom.generateNumber(MIN, MAX);

    }
}
