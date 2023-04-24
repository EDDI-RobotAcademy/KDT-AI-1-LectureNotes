package com.example.demo.homework.ResponseStringTest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
// Controller로 할 때는 안되다가 RestController로 바꿔주니 성공 ㅠㅠㅠ
@RequestMapping("/response-test")
public class ResponseHi {
    @GetMapping("/response-hi")
    public void helloTest() {
        log.info("안녕 요청!");
    }

    @GetMapping("/send-hi")
    public String sendHi() {
        log.info("안녕을 보낼게");

        return "안녕";
    }
}

// Controller는 클라이언트의 요청(Request)을 전달받는 코드
// 단순히 Json만을 반환하기 위해서는 RestController을 사용
// String을 return할 때는 RestController을 사용!!!
// 그냥 Controller는 Html 반환할 때 사용한다
// RestController이 백을 구성하여 프론트와 통신

