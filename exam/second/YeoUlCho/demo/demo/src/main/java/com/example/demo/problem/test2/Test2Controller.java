package com.example.demo.problem.test2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/message")
public class Test2Controller {

    @GetMapping("/hello")
    public String message(){
        final String message = "hi";
        return message;
    }
}
