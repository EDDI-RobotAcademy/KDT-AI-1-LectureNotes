package com.example.demo.problem;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("vue-test")
public class problem6 {

    @GetMapping("dice")
    public Integer dice() {
        final int diceNumber = 1;

        return diceNumber;
    }
}
