package com.example.demo.lectureClass.vue.homeworkSolve.dice;

import com.example.demo.lectureClass.untility.random.CustomRandom;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class Dice {
    final private static int MIN = 1;
    final private static int MAX = 6;
    final private int diceNumber;

    public Dice() {
        this.diceNumber = CustomRandom.generateNumber(MIN, MAX);
    }
}
