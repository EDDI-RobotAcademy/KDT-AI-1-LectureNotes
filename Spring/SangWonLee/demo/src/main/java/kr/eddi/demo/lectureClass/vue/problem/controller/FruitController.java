package kr.eddi.demo.lectureClass.vue.problem.controller;


import kr.eddi.demo.lectureClass.vue.problem.controller.form.FruitAppleWatermelonForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/apple-watermelon")
public class FruitController {

    private List<Integer> fruitSalesList = new ArrayList<>();

    @PostMapping("/number")
    public void appleWatermelonNumber(@RequestBody FruitAppleWatermelonForm fruitAppleWatermelonForm){
        log.info("received data: " + fruitAppleWatermelonForm);
        fruitAppleWatermelonForm.toFruit();
        System.out.println(fruitAppleWatermelonForm.toFruit());
        int watermelon1 = fruitAppleWatermelonForm.toFruit().getResultWatermelon();
        int apple1 = fruitAppleWatermelonForm.toFruit().getResultApple();

        fruitSalesList.add(watermelon1);
        fruitSalesList.add(apple1);

    }
    @GetMapping("/sales")
    public void appleWatermelonSales(){


    }

}
