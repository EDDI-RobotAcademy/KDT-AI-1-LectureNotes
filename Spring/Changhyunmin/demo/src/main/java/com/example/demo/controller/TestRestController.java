package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/rest-test")
public class TestRestController {

    @GetMapping("/first")
    public String firstTest () {
        return "응 이건 첫 번째야!";
    }
}
