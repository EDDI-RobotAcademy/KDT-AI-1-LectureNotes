package com.example.demo.lectureClass.vue.controller;

import com.example.demo.lectureClass.utility.random.CustomRandom;
import com.example.demo.lectureClass.form.VueRequestTestDataForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/vue-test")
public class VueTestController {

//    실제 @RequestMapping("/vue-test")와 @PostMapping("/receive-test")로 URL 경로가 만들어짐
    // vue에서 날린 정보는 객체화 된다.
    // 아래쪽에 있는 @RequestBody를 살펴봐야 합니다.
    // 객체화된 정보 집합을 받을 때 아래와 같이 @RequestBody를 사용합니다.
    // 또한 주의할 부분이 있는데 VueRequestTestDataForm은 vue가 전송한 양식을 통일하게 유지하고 있어야 합니다.
    // 전송한 이름에 해당하는 studentName, studentAge 같은 정보가 정확하게 일치해야 합니다.
    @PostMapping("/receive-test")
    public void receiveTest(@RequestBody VueRequestTestDataForm vueRequestTestDataForm) {
        log.info("recieved data" + vueRequestTestDataForm); // 받은 정보를 "recieved data"로 확인할 수 있었음
    } // log.info 뭐가 어디있는지 어떤 정보가 있는지 파악할 수 있게 해줌
    // VueRequestTestDataForm 실제로 vue에서 전송한 정보들이 전달되는 곳
    // 변수 이름을 동일하게 맞춰주어야 한다
    // 변수 이름이 안맞으면 확인 못함

    @GetMapping("/get-random-dice") // 그냥 달라고 요청하는 거니까 파라메터 필요 없음
    public Integer getRandomDice() {
        final int MIN = 1;
        final int MAX = 6;

        log.info("getRandomDice() 요청!");

        return CustomRandom.generateNumber(MIN, MAX);
    }

}
