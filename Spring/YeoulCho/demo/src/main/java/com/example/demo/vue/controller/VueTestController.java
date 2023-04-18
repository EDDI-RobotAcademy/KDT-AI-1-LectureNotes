package com.example.demo.vue.controller;


import com.example.demo.lectureClass.homework.DiceManager;
import com.example.demo.lectureClass.utility.random.CustomRandom;

import com.example.demo.vue.controller.form.VueRequestTestDataForm;
import com.example.demo.vue.controller.form.homework.VueRequestTest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;

@Slf4j
@RestController
@RequestMapping("/vue-test")
public class VueTestController {

    /*
        실제 @RequestMapping("/vue-test")와 @PostMapping("/receive-test")로 URL 경로가 만들어짐
        아래쪽에 있는 @RequestBody를 살펴봐야 합니다.
        객체화된 정보 집합을 받을 때 아래와 같이 @RequestBody를 사용합니다.
        또한 주의할 부분이 있는데 VueRequestTestDataForm은 vue가 전송한 양식을 동일하게 유지하고 있어야 합니다.
        전송한 이름에 해당하는 studentName, studentAge 같은 정보가 정확하게 일치해야 합니다.
         */
    @PostMapping("/receive-test")
    public void receiveTest (@RequestBody VueRequestTestDataForm vueRequestTestDataForm) {
        log.info("received data: " + vueRequestTestDataForm);
    }

    @GetMapping("/get-random-dice")
    public Integer getRandomDice () {
        final int MIN = 1;
        final int MAX = 6;

        log.info("getRandomDice() 요청!");

        return CustomRandom.generateNumber(MIN, MAX);
    }
    @GetMapping("/get-random-dice-game")
    public int sumTwoDice(){
        DiceManager d1 = new DiceManager();
        DiceManager d2 = new DiceManager();
        int tmpSum = d1.randomDiceNumber +d2.randomDiceNumber;
        System.out.println(tmpSum);
        return tmpSum;}

    @PostMapping("/basic-problem-test") //안녕 메시지 받기 //404오류
    public void basicProblemTest (@RequestBody VueRequestTest vueRequestTest) {
        log.info("received data: " + vueRequestTest);
    }
    @GetMapping("/get-message")
    public String getMessage(){
        String Message ="안녕";

        return Message;}


}

