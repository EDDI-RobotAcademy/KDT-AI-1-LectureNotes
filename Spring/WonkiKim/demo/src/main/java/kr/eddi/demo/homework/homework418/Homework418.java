package kr.eddi.demo.homework.homework418;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("homework-418")
public class Homework418 {
    final static int priceApple=2000;
    final static int priceWatermelon =10000;

    int totalApplePrice;
    int totalWatermelonPrice;
    int totlaPrice;

    int totalPrice;
    @PostMapping("calculate-price")
    public void calculatePrice(@RequestBody FruitRequestForm fruitRequestForm) {
        log.info(String.valueOf(fruitRequestForm));
        totalApplePrice = fruitRequestForm.numApple * priceApple;
        totalWatermelonPrice = fruitRequestForm.numWatermelon * priceWatermelon;
        totalPrice = totalApplePrice + totalWatermelonPrice;

    }

    @GetMapping("get-total-price")
    public FruitReciptResponsForm getTotalPrice() {
        return new FruitReciptResponsForm(totalApplePrice, totalWatermelonPrice, totalPrice);
    }
}
