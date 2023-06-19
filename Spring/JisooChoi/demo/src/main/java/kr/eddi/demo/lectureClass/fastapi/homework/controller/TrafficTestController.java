package kr.eddi.demo.lectureClass.fastapi.homework.controller;

import kr.eddi.demo.lectureClass.fastapi.basics.service.FastApiService;
import kr.eddi.demo.lectureClass.fastapi.homework.service.TrafficTestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/homework-test")
public class TrafficTestController {

    final private TrafficTestService trafficTestService;

    @GetMapping("/vue-spring")
    public Integer fastApiStringRequest () {
        log.info("vue-spring()");

        return trafficTestService.randomNumber();
    }

    @GetMapping("/vue-spring-fastapi")
    public Integer fastApiRandomNumRequest () {
        log.info("fastApiRandomNumRequest()");

        final String FASTAPI_REQUEST_URL = "http://localhost:8000/request-random-data";

        return trafficTestService.randomNumRequest(FASTAPI_REQUEST_URL);
    }
}