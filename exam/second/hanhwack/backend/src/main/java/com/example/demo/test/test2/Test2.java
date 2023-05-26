package com.example.demo.test.test2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/hello")
public class Test2 {
    @GetMapping("/get")
    public String getMessage () {

        final String answer = "hi";

        log.info("getMessage() 요청");

        return answer;
    }
}
