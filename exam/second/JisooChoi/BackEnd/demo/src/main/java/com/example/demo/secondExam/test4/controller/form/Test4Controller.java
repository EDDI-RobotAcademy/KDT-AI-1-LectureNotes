package com.example.demo.secondExam.test4.controller.form;

import com.example.demo.secondExam.utility.random.CustomRandom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/exam-test4")
public class Test4Controller {

/*
    ★ 4번 문제 백엔드 백로그

    1. URL 맵핑을 통해 주사위 값 요청이 되면 임의의 주사위 값을 구해서 리턴해줍니다.
    - Success Criteria
        (1) 외부의 Request(요청)을 수신할 수 있도록 Controller 를 만듭니다.
        (2) 외부 요청을 수신하여 임의의 주사위 값을 구합니다.
        (3) 값이 잘 구해졌다면 주사위 값을 리턴합니다.

    - To Do
        [o] 요청을 수신할 Controller 생성
        [o] 임의의 주사위 값 구하기
 */

    @GetMapping("/dice-number")
    public Integer testFour (){
        log.info("testFour()");

        final Integer MAX = 6;
        final Integer MIN = 1;

        return CustomRandom.generateNumber(MAX, MIN);
    }
}
