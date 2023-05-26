package com.example.demo.problem4;

import com.example.demo.problem4.dice.Dice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/problem4")
public class Problem4 {
    /*
        백엔드 백로그
        1. 프론트에 주사위 정보를 보내기 위한 작업을 진행합니다
           - 주사위를 굴려서 랜덤한 숫자가 나오게 합니다
        2. 프론트로 정보를 보내기 위한 구성을 진행합니다
     */

    @GetMapping("/dice")
    public Integer Practice4() {
        Dice dice = new Dice();

        return dice.getDiceNumber();
    }
}
