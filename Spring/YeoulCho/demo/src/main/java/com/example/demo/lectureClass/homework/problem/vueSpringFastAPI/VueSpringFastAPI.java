package com.example.demo.lectureClass.homework.problem.vueSpringFastAPI;

import com.example.demo.lectureClass.homework.problem.vueSpringFastAPI.service.Prob3Service;
import com.example.demo.lectureClass.utility.random.CustomRandom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/vue-spring")
public class VueSpringFastAPI {
    final private Prob3Service prob3Service;
    @GetMapping("/first-number")
    public Integer firstNumber(){
        int firstNum= CustomRandom.generateNumber(5,20);
        return firstNum;
    }
    @GetMapping("/second-number")
    public Integer secondNumber(){
        final String FASTAPI_REQUEST_URL="http://localhost:8000/request-second-num";
        return prob3Service.secondNumRequest(FASTAPI_REQUEST_URL);
    }
}
