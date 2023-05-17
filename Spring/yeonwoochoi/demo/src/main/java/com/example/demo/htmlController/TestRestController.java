package com.example.demo.htmlController;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// localhost:8080/html/first

// RestController 가 붙어 있으면 데이터를 JSON 이라는 형태로 내보내게 됩니다.
// Web 상에서 데이터를 주고 받는 방식은 대부분 이 JSON 방식을 사용하게 됩니다.
// 그러므로 데이터를 주고 받는 상화에서는 전부 RestController를 사용하게 됩니다.
// 물론 Legacy Project의 경우 Backend와 Frontend가 결합되어 있습니다.
// 이런 경우엔 Controller를 사용하게 됩니다.

// 최신 트렌드는 Front쪽과 통신하기 위해 RestController로 Back을 구성합니다.
@Slf4j
@RestController
@RequestMapping("/rest-test") // rest 그냥 스트링 리턴 했는데 출력이 되었음
public class TestRestController {

    // 서버란 무엇일까요 ?
    // - 데이터를 처리하는 주체 (커피 머신을 동작시켜서 커피를 만들어서 제공)
    // Response(응답)을 하면 서버

    // 클라이언트는 무엇일까요 ?
    // - 데이터를 요청하는 주체 (카페에서 주문)
    // Request(요청)을 하면 클라이언트
    @GetMapping("/first")
    public String firstTest (){
        return "음 이건 첫 번째야!";
    }
}
