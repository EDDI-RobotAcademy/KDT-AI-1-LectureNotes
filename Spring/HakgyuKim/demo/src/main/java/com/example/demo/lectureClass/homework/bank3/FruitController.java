package com.example.demo.lectureClass.homework.bank3;

import com.example.demo.lectureClass.homework.bank3.form.FruitProblemForm;
import com.example.demo.lectureClass.homework.bank3.fruit.Apple;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/fruit-problem")
public class FruitController {
private int appleCount;
private int watermelonCount;

    @PostMapping("/appleCount")
    public void appleCount (@RequestBody Integer appleCount) {
        log.info("received data: " + appleCount);
        this.appleCount = appleCount;
    }
    @GetMapping("/buyApple")
    public Integer buyApple() {
        Apple apple = new Apple();
        return apple.getPrice() * appleCount;
    }
}
