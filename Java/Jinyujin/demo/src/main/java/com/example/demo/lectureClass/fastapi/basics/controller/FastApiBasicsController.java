package com.example.demo.lectureClass.fastapi.basics.controller;

import com.example.demo.lectureClass.fastapi.basics.service.FastApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/fastapi-test")
public class FastApiBasicsController {

    final private FastApiService fastApiService;

    @GetMapping("/fastapi-string-request")
    public void fastApiStringRequest() {
        log.info("fastapi string request");

        final String FASTAPI_REQUEST_URL = "http://localhost:8000/request_data";
        // 서버꺼

        fastApiService.stringRequest(FASTAPI_REQUEST_URL);
        // 통신이 되면 터미널에 result: {"name":"Hi","major":"C"} 이렇게 떠야 함
        // 파이썬에서 통신하기 위해 써놓은 것!
    }

    @GetMapping("/fastapi-integer-request")
    public Integer fastApiIntegerRequest() {
        log.info("fastapi integer request");

        final String FASTAPI_REQUEST_URL = "http://localhost:8000/request_int_data";
        // 서버꺼

        return fastApiService.integerRequest(FASTAPI_REQUEST_URL);
    }
}


