package com.example.demo.exam.exam4.controller;

import com.example.demo.exam.exam4.entity.Dice;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/dice")
public class Exam4Controller {


    @GetMapping("roll-dice")
    public Dice rollDice () {
        return new Dice();
    }
}
