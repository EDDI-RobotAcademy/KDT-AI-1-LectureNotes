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
    public FruitForm purchaseApple() {
        log.info("purchase-apple()");
        Fruit fruitApplePurchase = new Fruit();
        fruitApplePurchase.purchaseApple(3);

        return fruitApplePurchase;

    }

    @GetMapping("/purchase-watermelon")
    public FruitForm purchaseApple() {
        log.info("purchase-watermelon()");
        Fruit fruitWatermelonPurchase = new Fruit();

        fruitWatermelonPurchase.purchaseWatermelon(5);
    }
}
