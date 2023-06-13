package com.example.demo.problem.problem4;


import com.example.demo.random.CustomRandom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

// 문제 4 ~ 6
/*
문제 4번 Backlog 작성
1. Vue 와 주고 받을 컨트롤러 만들기
2. 컨트롤러 부분에 랜덤 주사위를 구현하기
3. 스프링에 요청한 주사위 굴리기를 출력하기 위한 Vue 파트 구성
*/
@Slf4j
@RestController
@RequestMapping("/vue")
public class Problem4Controller {

    @GetMapping("/get-random-dice")
    public Integer getRandomDice() {
        final int MIN = 1;
        final int MAX = 6;

        log.info("getRandomDice() 요청!");

        return CustomRandom.generateNumber(MIN, MAX);
    }
}
