package com.example.demo.secondExam.test2.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/exam-test")
public class Test2Controller {

    @GetMapping("/test-two-hi")
    public String testTwo (){
        log.info("testTwo()");
        return "Hi";
    }
}
