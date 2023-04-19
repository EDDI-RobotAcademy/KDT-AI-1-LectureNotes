package com.example.demo.controller.lectureClass.homework.controller;

import com.example.demo.controller.lectureClass.homework.problem1.Fruits;
import com.example.demo.controller.lectureClass.homework.problem1.Price;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/apple-watermelon")
public class PriceController {
    @GetMapping("/result")
    // 직접적으로 겟할 폴더를 들고와야 하는거같음
    public Fruits doResult () {
        log.info("result()");

        Price price = new Price();
        log.info("price: " + price);

        int PriceSum = price.calculatePriceSum();
        Fruits fruits = new Fruits(price.getApplePrice(),price.getWatermelonPrice(), PriceSum);
        log.info("fruits: " + fruits);

        return fruits;
    }
}

