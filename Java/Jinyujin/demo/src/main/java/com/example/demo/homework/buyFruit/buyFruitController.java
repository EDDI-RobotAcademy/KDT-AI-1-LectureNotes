package com.example.demo.homework.buyFruit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 여기서 데이터 전송
// 과일 가격 계산하는 프로그램
@Slf4j
@RestController
@RequestMapping("/buy-fruit")
public class buyFruitController {

    @GetMapping("/get-price-sum")
    public FruitForm buyFruitController(GetFruitsPrice getFruitsPrice) {
        // 전송 잘 되는지 알아보자 - 잘됨
//        log.info("all good?");

        getFruitsPrice = new GetFruitsPrice(getFruitsPrice.getAppleCount(), getFruitsPrice.getWatermelonCount());

        int priceSum = getFruitsPrice.calculatePriceSum();
        FruitForm fruitForm = new FruitForm(priceSum, getFruitsPrice.getAppleCount(), getFruitsPrice.getWatermelonCount());

        return fruitForm;
    }
}

