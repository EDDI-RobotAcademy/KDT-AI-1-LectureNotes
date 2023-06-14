/*
Spring을 이용해서 http://localhost:7777/hello 에 GET 요청을 보내면
"hi" 응답을 리턴하도록 만들어봅시다.
*/
package com.example.demo.problem2;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController

public class GetHi {

    @GetMapping("/hello")
    public String hello() {
        return "hi";
    }
}
