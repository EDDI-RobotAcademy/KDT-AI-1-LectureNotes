package kr.eddi.demo.html.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// RestController 가 붙어 있으면 데이터를 JSON이라는 형태로 내보내게 됩니다.
//web 상에서 데이터를 주고 받는 방식은 대부분 이 json이라는 방식을 사용하게됩니다.
// 그러므로 데이터를 주고 받는 상황에서는 전부 RestController가 사용하게 됩니다.
// 물론 Legacy Project의 경우 Backend와 Frontend가 결합되어 있습빈다.
// 이런 경우에 Controller를 사용하게 됩니다.
//
// 최신 트렌드는 Front쪽과 통신하기 위해 RestController 로 Back을 구성합니다.

@RestController
@RequestMapping("/rest-test")
@Slf4j
public class TestRestController {
    // 서버란 무엇일까요?
    // -데이터 베이스 같은 것인가요?
    // -중개소 같은 느낌
    // -(정답)데이터를 처리하는 주체.(커피 머신을 동작시켜서 커피를 만들어서 제공함)
    // Response(응답)하면 서버

    // 클라이언트 무엇일까요?
    // -데이터 요청하는 주체.(커피숍 가서 주문)
    // REquest (요청)을 하면 클라이언트
    @GetMapping("/first")
    public String firstTest(){
        return "이게 첫 번째!";
    }
}
