package com.example.demo.lectureClass.fastapi.homework.controller;

import com.example.demo.lectureClass.fastapi.basics.service.FastApiService;
import com.example.demo.lectureClass.fastapi.homework.service.FastApiHomeworkService;
import com.example.demo.lectureClass.untility.random.CustomRandom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/getNumber")
public class FastApiHomeworkController {

    final private FastApiHomeworkService fastApiHomeworkService;

    @GetMapping("/first")
    public Integer firstNumber() {
        log.info("firstNumber");

        return CustomRandom.generateNumber(1,10);
    }

    @GetMapping("/second")
    public Integer secondNumber() {
        log.info("secondNumber");

        final String FASTAPI_REQUEST_URL = "http://localhost:8000/request-second-data";

        return fastApiHomeworkService.secondNumberRequest(FASTAPI_REQUEST_URL);
    }
}

