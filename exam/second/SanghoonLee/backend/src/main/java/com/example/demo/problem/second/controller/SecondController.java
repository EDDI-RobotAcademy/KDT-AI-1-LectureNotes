package com.example.demo.problem.second.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecondController {

    @GetMapping("/hello")
    public String sayHello () {
        return "hi";
    }
}
