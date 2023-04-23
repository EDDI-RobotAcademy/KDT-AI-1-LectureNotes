package kr.eddi.demo.lectureClass.vue.problem6.controller;

import kr.eddi.demo.lectureClass.vue.problem6.controller.form.FruitCostForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/fruit-shop")
public class VueFruitController {

    final int appleBasicCost = 2000;
    final int watermelonBasicCost = 10000;

    @PostMapping("/buy")
    public FruitCostForm buyFruitResultCost (@RequestBody FruitCostForm fruitCostForm){
        log.info("buyFruitResultCost() 확인");

        // 과일이 존재한다면 리스트에 과일 이름을 넣어라
        if(fruitCostForm.getAppleNum() > 0){
            fruitCostForm.myFruit += " 사과";
        }
        if(fruitCostForm.getWatermelonNum() > 0){
            fruitCostForm.myFruit += " 수박";
        }

        // 과일 가격 계산하기
        int appleResult = fruitCostForm.getAppleNum() * appleBasicCost;
        int watermelonResult = fruitCostForm.getWatermelonNum() * watermelonBasicCost;
        fruitCostForm.totalFruitCost= appleResult + watermelonResult;

        return fruitCostForm;
    }

}
