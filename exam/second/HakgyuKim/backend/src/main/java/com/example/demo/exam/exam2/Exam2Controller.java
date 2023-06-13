package com.example.demo.exam.exam2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class Exam2Controller {

    @GetMapping("/hello")
    public String getHello () {
        final String hello = "hi";
        return hello;
    }
}
