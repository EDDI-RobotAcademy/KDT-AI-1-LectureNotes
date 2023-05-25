package com.example.demo.evaluation.problem2;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 문제 2번
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/problem2")
public class Problem2Controller {
    @GetMapping("/hello")
    public String sayHi () {
        log.info("sayHi()");

        String message = "hi";

        return message;
    }
}
