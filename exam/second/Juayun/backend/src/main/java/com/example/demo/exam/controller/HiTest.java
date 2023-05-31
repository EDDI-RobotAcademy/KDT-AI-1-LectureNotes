package com.example.demo.exam.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/exam")
public class HiTest {

    @GetMapping("/hello")
    public String hello() {
        log.info("hello()");
        return "hi";
    }
}
