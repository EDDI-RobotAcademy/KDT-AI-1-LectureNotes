package com.example.demo.lectureClass.homework.pythonVueSpringBank1.controller;

import com.example.demo.lectureClass.homework.pythonVueSpringBank1.service.PythonVueSpringService;
import com.example.demo.lectureClass.utility.CustomRandom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/python-vue-spring")
public class PythonVueSpringBank3Controller {

    final private PythonVueSpringService pythonVueSpringService;

    @GetMapping("/pass-python-request")
    public Integer passPythonRequest() {
        final String FASTAPI_REQUEST_URL = "http://localhost:8000/request-pass-string";

        return pythonVueSpringService.integerRequest(FASTAPI_REQUEST_URL);
    }

    @GetMapping("/spring-request")
    public Integer springRequest() {
        Integer randomNum = CustomRandom.generateNumber(5, 20);

        return randomNum;
    }
}
