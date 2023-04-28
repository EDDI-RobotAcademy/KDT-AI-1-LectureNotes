package com.example.demo.lectureClass.vue.controller;


import com.example.demo.lectureClass.utility.CustomRandom;
import com.example.demo.lectureClass.vue.controller.form.VueRequestTestDataForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/vue-test")
public class VueTestController {

    /*
    실제 @RequestMapping("/vue-test")와 @PostMapping("/receive-test")로 URl 경로가 만들어짐
    아래쪽에 있는 @RequestBody를 살펴봐야합니다.
    객체화된 정보 집합을 받을 때 아래와 같이 @RequestBody를 사용합니다.
    또한 주의할 부분이 있는데 VueRequestTestDataForm은 vue가 전송한 양식을 동일하게 유지하고 있어야 합니다.
    전송한 이름에 해당하는 studentName, studentAge, 같은 정보가 정확하게 일치해야 합니다.
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

    @GetMapping("/roll-two-dice")
    public String rollTwoDice () {
        final int MIN = 1;
        final int MAX = 6;
        log.info("rollTwoDice() 요청!");
        int dice1 = CustomRandom.generateNumber(MIN, MAX);
        int dice2 = CustomRandom.generateNumber(MIN, MAX);
        int diceSum = dice1 + dice2;
        if (diceSum % 2 == 0) {
            return ("주사위 1: " + dice1 +
                    ", 주사위 2: " + dice2 +
                    ", 주사위의 핪: " + diceSum + ", 승리!!");
        }
        return ("주사위 1: " + dice1 +
                ", 주사위 2: " + dice2 +
                ", 주사위의 핪: " + diceSum + ", 패배!!");
    }
}
