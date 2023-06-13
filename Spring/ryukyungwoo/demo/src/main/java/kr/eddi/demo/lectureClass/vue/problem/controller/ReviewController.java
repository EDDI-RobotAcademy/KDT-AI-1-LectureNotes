package kr.eddi.demo.lectureClass.vue.problem.controller;

import kr.eddi.demo.lectureClass.vue.problem.controller.form.FruitForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/buy-fruit")
public class ReviewController {

    @PostMapping("/get-price-sum")
    public Integer buyFruitController(@RequestBody FruitForm fruitForm) {

        final int APPLE_PRICE = 2000;
        final int WATERMELON_PRICE = 10000;

        return APPLE_PRICE * fruitForm.getAppleCount() +
                WATERMELON_PRICE * fruitForm.getWatermelonCount();
    }
}
