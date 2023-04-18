package com.example.demo.lectureClass.vue.homework.controller;

import com.example.demo.lectureClass.vue.homework.controller.form.BuyFruitResponseForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/buy-fruit")
public class VueHomework3Controller {

    @PostMapping("/apple")
    public void receiveAppleNum (@RequestBody BuyFruitResponseForm buyFruitResponseForm) {
        log.info("received data: " + buyFruitResponseForm);

//        BuyFruitList appleBuyFruitList = new BuyFruitList();
//        int appleTotalPrice = appleBuyFruitList.totalApplePrice(buyFruitResponseForm.getFruitNum());
//        log.info("appleTotalPrice: " + appleTotalPrice);
//        return appleTotalPrice;
    }

    @PostMapping("/watermelon")
    public void receiveWaterMelonNum (@RequestBody BuyFruitResponseForm buyFruitResponseForm) {
        log.info("received data: " + buyFruitResponseForm);
    }
}
