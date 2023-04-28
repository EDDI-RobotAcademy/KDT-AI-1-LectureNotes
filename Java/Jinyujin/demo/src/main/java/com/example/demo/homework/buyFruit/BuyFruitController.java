package com.example.demo.homework.buyFruit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

// 여기서 데이터 전송
// 과일 가격 계산하는 프로그램
@Slf4j
@RestController
@RequestMapping("/buy-fruit")
public class BuyFruitController {

    @PostMapping("/get-price-sum")
    public Integer buyFruitController(@RequestBody FruitForm fruitForm) {
        // 전송 잘 되는지 알아보자 - 잘됨
//        log.info("all good?");

        final int APPLE_PRICE = 2000;
        final int WATERMELON_PRICE = 10000;

        int priceSum = (fruitForm.getAppleCount() * APPLE_PRICE) +
                (fruitForm.getWatermelonCount() * WATERMELON_PRICE);

        return priceSum;
    }
}

