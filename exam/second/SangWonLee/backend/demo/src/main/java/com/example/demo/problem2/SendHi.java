package com.example.demo.problem2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/problem2")
public class SendHi {
    @GetMapping("/hello")
    public String receivedHello () {
        String Hello = "hi";

        log.info("버튼 눌렸다.");

        return Hello;
    }
}
