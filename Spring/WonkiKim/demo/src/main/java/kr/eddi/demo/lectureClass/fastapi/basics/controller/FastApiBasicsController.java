package kr.eddi.demo.lectureClass.fastapi.basics.controller;

import kr.eddi.demo.lectureClass.fastapi.basics.service.FastApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/fastapi-test")
public class FastApiBasicsController {
    final private FastApiService fastApiService;
    @GetMapping("/fastapi-string-request")
    public void fastApiStringRequest() {
        log.info("fastapi string request");
        final String FASTAPI_REQUEST_URL = "http://localhost:8000/request-data";
        fastApiService.stringRequest(FASTAPI_REQUEST_URL);
    }

    @GetMapping("/fastapi-integer-request")
    public Integer fastApiIntegerRequest() {
        log.info("fastapi integer request");

        final String FASTAPI_REQUEST_URL = "http://localhost:8000/request-int-data";
        return fastApiService.integerRequest(FASTAPI_REQUEST_URL);
    }

    @GetMapping("request-random-number")
    public Integer requestRandomNumber() {
        return (int) (Math.random() * 21 + 5);
    }

    @GetMapping("request-random-number-to-fastapi")
    public Integer requestRandomNumber2fastapi() {
        final String FASTAPI_REQUEST_URL = "http://localhost:8000/request-random-number";
        return fastApiService.requestRandomNumber(FASTAPI_REQUEST_URL);
    }

}
