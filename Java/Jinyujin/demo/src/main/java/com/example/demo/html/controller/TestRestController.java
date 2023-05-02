package com.example.demo.html.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/rest-test")
public class TestRestController {

    // 서버란 무엇일까요?
    // - 데이터를 처리하는 주체 (커피 머신을 종작시켜서 커피를 만들고 제공)
    // Response(응답)을 하면 서버
    // 우리가 보고 있는 화며 자체가 서버가 답한 것

    // 클라이언트는 무엇일까요?
    // - 데이터를 요청하는 주체 (커피숍 가서 주문)
    // Request(요청)을 하면 클라이언트
    @GetMapping("/first")
    public String firstTest() {
        return "응 이건 첫 번째야!";
    }
}
