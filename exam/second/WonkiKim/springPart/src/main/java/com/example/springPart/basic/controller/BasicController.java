package com.example.springPart.basic.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/basic")
public class BasicController {
    @GetMapping("/get-hi")
    public String problem2() {
        log.info("problem2()");
        return "Hi";
    }

    @GetMapping("/get-dice")
    public Integer problem6() {
        final int MAX = 6;
        final int MIN = 1;
        log.info("problem6()");
        return Integer.valueOf(((int)(Math.random() * (MAX+MIN -1)) +MIN));
    }
}
