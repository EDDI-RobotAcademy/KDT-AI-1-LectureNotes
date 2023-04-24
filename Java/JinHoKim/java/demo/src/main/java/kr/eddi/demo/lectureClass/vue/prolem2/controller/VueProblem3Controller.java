package kr.eddi.demo.lectureClass.vue.prolem2.controller;

import kr.eddi.demo.lectureClass.vue.prolem2.controller.form.FruitForm;
import kr.eddi.demo.lectureClass.vue.prolem2.fruit.Fruit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/purchase-fruit")
public class VueProblem3Controller {

    @GetMapping("/purchase-apple")
    public int purchaseApple() {
        log.info("purchase-apple()");
        Fruit fruitApplePurchase = new Fruit();
        int appleTotalPrice =
        fruitApplePurchase.purchaseApple(3);

        return appleTotalPrice;

    }

    @GetMapping("/purchase-watermelon")
    public int purchaseWatermelon() {
        log.info("purchase-watermelon()");
        Fruit fruitWatermelonPurchase = new Fruit();

        int watermelonTotalPrice =
        fruitWatermelonPurchase.purchaseWatermelon(5);
        return watermelonTotalPrice;
    }
}
