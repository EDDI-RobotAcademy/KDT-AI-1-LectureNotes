package com.example.demo.lectureClass.vue.homework.controller;

import com.example.demo.lectureClass.vue.homework.controller.form.BuyFruitResponseForm;
import com.example.demo.lectureClass.vue.homework.fruit.BuyFruit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/buy-fruit")
public class VueHomework3Controller {
    private int appleTotalPrice;
    private int waterMelonTotalPrice;

    @PostMapping("/apple")
    public int receivedAppleNum (@RequestBody BuyFruitResponseForm buyAppleResponseForm) {
        log.info("received data: " + buyAppleResponseForm);

        BuyFruit buyApple = new BuyFruit();
        appleTotalPrice =
                buyApple.calculateApplePrice(buyAppleResponseForm.getFruitNum());

        return appleTotalPrice;
    }

    @PostMapping("/watermelon")
    public int receivedWaterMelonNum (@RequestBody BuyFruitResponseForm buyWaterMelonResponseForm) {
        log.info("received data: " + buyWaterMelonResponseForm);

        BuyFruit buyWatermelon = new BuyFruit();
        waterMelonTotalPrice =
                buyWatermelon.calculateWaterMelonPrice(buyWaterMelonResponseForm.getFruitNum());

        return waterMelonTotalPrice;
    }
}
