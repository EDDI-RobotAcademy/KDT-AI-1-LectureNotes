package com.example.demo.lectureClass.vue.homework.controller;

import com.example.demo.lectureClass.vue.homework.controller.form.BuyFruitsForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/fruits-store")
public class VueWeekendHomework1Controller {
    @PostMapping("/calculate-fruits")
    public int receivedAppleNum(@RequestBody BuyFruitsForm buyFruitsForm) {
        log.info("received data: " + buyFruitsForm);

        final int APPLE_COST = 2000;
        final int WATERMELON_COST = 10000;

        final int totalPrice = buyFruitsForm.getAppleNum() * APPLE_COST
                + buyFruitsForm.getWatermelonNum() * WATERMELON_COST;

        return totalPrice;
    }
}
