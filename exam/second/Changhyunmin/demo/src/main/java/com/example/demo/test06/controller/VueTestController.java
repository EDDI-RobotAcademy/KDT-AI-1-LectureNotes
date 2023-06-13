package com.example.demo.test06.controller;

import com.example.demo.test06.controller.form.VueRequestTestForm;
import com.example.demo.utility.CustomRandom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/*
spring
1.사용할 1~6의 수를 갖은 주사위 만들기
2.주사위에 렌덤성을 부여하기
*/

@Slf4j
@RestController
@RequestMapping("/vue-test")
public class VueTestController {
    @PostMapping("/receive-test")
    public void receiveTest(@RequestBody VueRequestTestForm vueRequestTestDataForm) {
        log.info("received data: " + vueRequestTestDataForm);
    }

    @GetMapping("/get-random-dice")
    public Integer getRandomDice() {
        final int MIN = 1;
        final int MAX = 6;

        log.info("getRandomDice() 요청!");

        return CustomRandom.generateNumber(MIN, MAX);
    }
}