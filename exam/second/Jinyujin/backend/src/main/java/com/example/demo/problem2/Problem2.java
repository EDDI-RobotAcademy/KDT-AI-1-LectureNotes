package com.example.demo.problem2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class Problem2 {

    @GetMapping("/hello")
    public String sayHiToVue() {

        final String message = "hi";
        log.info("sayHiToVue()");

        return message;
    }
}
