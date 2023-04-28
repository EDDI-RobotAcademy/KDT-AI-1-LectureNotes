package com.example.demo.controller.lectureClass.vue.problem.dice;

import com.example.demo.controller.lectureClass.utility.CustomRandom;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@RequiredArgsConstructor
public class Dice {

    // static 추가해줌
    final private static int MIN = 1;
    final private static int MAX = 6;
    final private int diceNumber;

    public Dice() {
        this.diceNumber = CustomRandom.generateNumber(MIN,MAX);
    }
}
