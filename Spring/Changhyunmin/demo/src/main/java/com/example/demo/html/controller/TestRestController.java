package com.example.demo.html.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//RestController 가 붙어있으면 데이터를 JSON 이라는 형태로 내보내게 됩니다.
//Wab사에서 데이터를 주고 밭는 방식은 대부분 이 JSON이라는 방식으로 사용하게 됩니다.
//그러므로 데이터를 주고 받는 상황에서는 전부 RestController 를 사용하게 됩니다.
// 물론 Legacyproject의 경우 Backend와 Frontend가 경합되있습니다/
//이런경우엔 Controller 를 사용하게됩니다.

//최신트랜드는 Front쪽과 통신하기위해
@Slf4j
@RestController
@RequestMapping("/html-test")
public class TestRestController {
    //서버란 무엇일까요?
    // - 데이터베이스 같은 것인가요?; (0) -> X(현재는 DB 없음)
    // - 중개소 같은느낌 (0)
    // - 데이터를 처리하는 주체 (커피머신을 동작시켜서 커피를 만들고 제공)
    //Response(응답)을 하면

    //클라이언트는 무엇일까요?
    // - 데이터를 요청하는 주체 (커피숍 가서 주문)
    @GetMapping("/first")
    public String firstTest(){
        return "응 이건 첫 번째야!";
    }
}
