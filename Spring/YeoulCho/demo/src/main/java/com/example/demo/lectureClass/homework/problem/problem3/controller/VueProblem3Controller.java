package com.example.demo.lectureClass.homework.problem.problem3.controller;

import com.example.demo.lectureClass.homework.problem.problem3.controller.form.FruitDataForm;
import com.example.demo.lectureClass.homework.problem.problem3.controller.form.FruitResponseForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/problem3")
public class VueProblem3Controller {


FruitDataForm fruitDataForm;

    @GetMapping("product-sum")
    public FruitResponseForm BuyProductSum(){
        int tmpSum=0;

        tmpSum = 2000* fruitDataForm.getApple() + 10000* fruitDataForm.getWatermelon();
        log.info(String.valueOf(tmpSum));
        FruitResponseForm fruitResponseForm =new FruitResponseForm(tmpSum, fruitDataForm.getApple(), fruitDataForm.getWatermelon());
        return fruitResponseForm;

    }
    @PostMapping("buy-product")
    public void ProductList(@RequestBody FruitDataForm fruitDataForm){
        log.info("received Data: " + fruitDataForm);
        this.fruitDataForm = fruitDataForm;
    }

}
