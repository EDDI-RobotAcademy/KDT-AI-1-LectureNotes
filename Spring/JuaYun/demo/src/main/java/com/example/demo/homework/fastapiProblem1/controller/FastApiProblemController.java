package com.example.demo.homework.fastapiProblem1.controller;

import com.example.demo.homework.fastapiProblem1.service.FastApiProblemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/fastapi-problem")
public class FastApiProblemController {

    final private FastApiProblemService fastApiProblemService;

    @GetMapping("/fastapi-integer-request")
    public Integer fastApiIntegerRequest () {
        log.info("fastapi integer request");

        final String FASTAPI_REQUEST_URL = "http://127.0.0.1:8000/request-int-prob";

        return fastApiProblemService.integer(FASTAPI_REQUEST_URL);
    }
}
