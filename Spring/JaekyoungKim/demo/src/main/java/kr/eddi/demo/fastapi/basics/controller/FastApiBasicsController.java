package kr.eddi.demo.fastapi.basics.controller;

import kr.eddi.demo.fastapi.basics.service.FastApiService;
import kr.eddi.demo.utility.CustomRandom;
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
    public void fastApiStringRequest () {
        log.info("fastapi string request");

        final String FASTAPI_REQUEST_URL = "http://localhost:8000/request-data";

        fastApiService.stringRequest(FASTAPI_REQUEST_URL);
    }
    @GetMapping("/fastapi-integer-request")
    public Integer fastApiIntegerRequest () {
        log.info("fastapi integer request");

        final String FASTAPI_REQUEST_URL = "http://localhost:8000/request-int-data";

        return fastApiService.integerRequest(FASTAPI_REQUEST_URL);
}
    @GetMapping("/first")
    public Integer firstNumber () {
        log.info("fastapi integer request");

        final String FASTAPI_REQUEST_URL = "http://localhost:8000/request-int-data";
        return (Integer) CustomRandom.generateNumber(5,20);
    }
    @GetMapping("/second")
    public Integer secondNumber () {
        log.info("fastapi integer request");

        final String FASTAPI_REQUEST_URL = "http://localhost:8000/request-int-second";

        return fastApiService.integerRequest(FASTAPI_REQUEST_URL);
    }
}