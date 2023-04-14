package kr.eddi.demo.html.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/rest-test")
public class TestRestController {

    // 서버란 무엇일까요 ?
    // - 데이터베이스 같은 것인가요? (0) -> X (현재는 DB 없음)
    // - 중개소 같은 느낌 (0)
    // - 데이터를 처리하는 주체 (커피 머신을 동작시켜서 커피를 만들고 제공)
    // Response(응답)을 하면 서버

    // 클라이언트는 무엇일까요 ?
    // - 데이터를 요청하는 주체 (커피숍 가서 주문)
    // Request(요청)을 하면 클라이언트

    @GetMapping("/first")
    public String firstTest(){
        return "응 이건 첫 번째야!";
        // RestController는 그냥 String을 리턴했다.
    }
}


