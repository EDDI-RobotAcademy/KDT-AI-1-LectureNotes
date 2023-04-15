package com.example.demo.html.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// RestController 가 붙어 있으면 데이터를 JSON 이라는 형태로 내보내게 됩니다.
// Web 상에서 데이터를 주고 받는 방식은 대부분 이 JSON 방식을 사용하게 됩니다.
// 그러므로 데이터를 주고 받는 상황에서는 전부 RestController 를 사용하게 됩니다.
// 물론 Legacy Project 의 경우 Backend 와 Frontend 가 결합되어 있습니다.
// 이런 경우엔 Controller 를 사용하게 됩니다.

// 최신 트렌드는 Front 쪽과 통신하기 위해 RestController 로 Back 을 구성합니다.
@Slf4j
@RestController
@RequestMapping("/rest-test")
public class TestRestController {

    // 서버란 무엇일까요?
    // - 데이터를 처리하는 주체 (커피머신을 동작시켜서 커피를 만들어서 제공)
    // spring 은 서버
    // Response (응답)을 하면 서버
    // 서버도 클라이언트가 되어서 정보를 주고 받을때도 있음

    // 클라이언트는 무엇일까요?
    // - 데이터를 요청하는 주체 (커피숍 가서 주문)
    // Request (요청)을 하면 클라이언트

    // RestController 는 String 을 받았는데도 그냥 출력이됨
    // html 이 필요없음
    @GetMapping("/first")
    public String firstTest () {
        return "응 이건 첫 번째야";
    }
}
