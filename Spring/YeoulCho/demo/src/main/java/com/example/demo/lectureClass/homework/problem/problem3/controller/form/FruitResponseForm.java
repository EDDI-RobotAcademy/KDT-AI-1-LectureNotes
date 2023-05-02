package com.example.demo.lectureClass.homework.problem.problem3.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class FruitResponseForm {
    int tmpSum;
    int watermelon;
    int apple;

    public FruitResponseForm(int tmpSum, int apple, int watermelon) {
        this.tmpSum = tmpSum;
        this.apple = apple;
        this.watermelon=watermelon;
    }
}
