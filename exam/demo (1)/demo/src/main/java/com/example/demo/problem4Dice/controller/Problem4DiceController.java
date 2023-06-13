package com.example.demo.problem4Dice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.problem4Dice.entity.Problem4Dice;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/problem-4-dice")
public class Problem4DiceController {

    @GetMapping("/get-random-dice")
    public Integer responseDiceIfRequestFromVue () {

        Problem4Dice problem4Dice = new Problem4Dice();

        return problem4Dice.getDiceNumber();
    }
}
