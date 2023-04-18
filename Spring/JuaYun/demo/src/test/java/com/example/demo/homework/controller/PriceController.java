package com.example.demo.homework.controller;

import com.example.demo.homework.problem1.Fruits;
import com.example.demo.homework.problem1.Price;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/apple-watermelon")
public class PriceController {

    @PostMapping("/result")
    public Price doResult () {
        log.info("result()");

        Fruits fruits = new Fruits();
        log.info("fruits: " + fruits);

        int PriceSum = Price.calculatePriceSum();
        Fruits fruits1 = new Fruits(PriceSum);

        log.info("fruits1: " + fruits1);
        return fruits1;
    }
}
