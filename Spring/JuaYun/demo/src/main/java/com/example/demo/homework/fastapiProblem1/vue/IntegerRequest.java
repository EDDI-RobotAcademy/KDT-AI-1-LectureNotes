package com.example.demo.homework.fastapiProblem1.vue;

import com.example.demo.utility.custom.CustomRandom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/request-test")
public class IntegerRequest {

    @GetMapping("/integer")
    public Integer random() {
        final int MIN = 5;
        final int MAX = 20;

        log.info("요청!");
        int number = CustomRandom.generateNumber(MIN, MAX);

        return number;
    }
}
