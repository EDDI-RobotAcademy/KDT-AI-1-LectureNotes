package com.example.demo.lectureClass.homework.bank3;

import com.example.demo.lectureClass.homework.bank3.form.FruitProblemForm;
import com.example.demo.lectureClass.homework.bank3.fruit.Apple;
import com.example.demo.lectureClass.homework.bank3.fruit.Watermelon;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/fruit-problem")
public class FruitController {
    List<Apple> appleList = new ArrayList<>();
    List<Watermelon> watermelonList = new ArrayList<>();

    @PostMapping("/buyFruit")
    public void appleCount (@RequestBody FruitProblemForm fruitProblemForm) {
        log.info("received data: " + fruitProblemForm);
        appleList.clear();
        watermelonList.clear();
        for (int i = 0; i < fruitProblemForm.getAppleCount(); i++) {
            appleList.add(new Apple());
        }
        for (int i = 0; i < fruitProblemForm.getWatermelonCount(); i++) {
            watermelonList.add(new Watermelon());
        }
    }

    @GetMapping("/total-price")
    public Integer getTotalPrice() {
        Apple apple = new Apple();
        Watermelon watermelon = new Watermelon();
        return (apple.getPrice() * appleList.size()) +
                (watermelon.getPrice() * watermelonList.size());
    }
}
