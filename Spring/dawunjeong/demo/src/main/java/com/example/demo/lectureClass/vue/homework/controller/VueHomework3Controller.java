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
    public void receiveAppleNum (@RequestBody BuyFruitResponseForm buyAppleResponseForm) {
        log.info("received data: " + buyAppleResponseForm);
        BuyFruit appleBuyFruit = new BuyFruit();
        appleTotalPrice = appleBuyFruit.totalApplePrice(buyAppleResponseForm.getFruitNum());
    }
    @GetMapping("/apple-price")
    public int getAppleTotalPrice() {
        log.info("appleTotalPrice: " + appleTotalPrice);
        return appleTotalPrice;
    }

    @PostMapping("/watermelon")
    public void receiveWaterMelonNum (@RequestBody BuyFruitResponseForm buyWaterMelonResponseForm) {
        log.info("received data: " + buyWaterMelonResponseForm);
        BuyFruit watermelonBuyFruit = new BuyFruit();
        waterMelonTotalPrice = watermelonBuyFruit.totalWaterMelonPrice(buyWaterMelonResponseForm.getFruitNum());
    }
    @GetMapping("/watermelon-price")
    public int getWatermelonTotalPrice() {
        log.info("waterMelonTotalPrice: " + waterMelonTotalPrice);
        return waterMelonTotalPrice;
    }
}
