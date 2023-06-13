package com.example.demo.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 9번 문제 DOMAIN SERVICE가 필요한 이유 //
// DOMAIN을 분리하여 목적성을 명확하게 하기 위해서 //

// 15번 문제 Test를 작성함으로서 얻게 되는 이점 //
// Test를 작성하면서 Domain을 파악할 수 있기 때문입니다.//


@Slf4j
@RestController
@RequestMapping("/rest-test")
public class TestRestController {

    @GetMapping("/hello")
    public String helloTest () {
        return "hi!";
    }
}
