package kr.eddi.demo.lectureClass.vue.problem6.controller;

import kr.eddi.demo.lectureClass.vue.problem6.controller.form.FruitCostForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/fruit-shop")
public class VueFruitController {

    final int appleBasicCost = 2000;
    final int watermelonBasicCost = 10000;

    @PostMapping("/buy")
    public Integer buyFruitResultCost (@RequestBody FruitCostForm fruitCostForm){
        log.info("buyFruitResultCost() 확인");

        // 과일 가격 계산하기
        int appleResult = fruitCostForm.getAppleNum() * appleBasicCost;
        int watermelonResult = fruitCostForm.getWatermelonNum() * watermelonBasicCost;

        int totalCost = appleResult + watermelonResult;

        return totalCost;
    }
}
