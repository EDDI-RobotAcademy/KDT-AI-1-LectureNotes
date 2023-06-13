package com.example.demo.homework.vueSpringFastApiFirst.controller;

import com.example.demo.homework.vueSpringFastApiFirst.Service.VueSpringFastApiService;
import com.example.demo.lectureClass.utility.random.CustomRandom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/vue-spring")
public class VSFController {

    final private VueSpringFastApiService vueSpringFastApiService;

    @GetMapping("/first-number")
    public Integer showFirstNumber() {
        log.info("showFirstNumber()");

        final Integer MIN = 5;
        final Integer MAX = 20;

        return CustomRandom.generateNumber(MIN,MAX);
    }

    @GetMapping("/second-number")
    public Integer showSecondNumber() {
        log.info("showSecondNumber()");

        final String FASTAPI_REQUEST_URL = "http://localhost:8000/request_second_number";

        return vueSpringFastApiService.integerRequest(FASTAPI_REQUEST_URL);
    }
}
