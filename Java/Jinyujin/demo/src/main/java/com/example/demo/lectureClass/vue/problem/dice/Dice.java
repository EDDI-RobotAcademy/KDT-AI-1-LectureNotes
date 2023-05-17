package com.example.demo.lectureClass.vue.problem.dice;

import com.example.demo.lectureClass.utility.random.CustomRandom;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class Dice {
    final static private int MIN = 1;
    final static private int MAX = 6;
    final private int diceNumber;

    public Dice() {
        this.diceNumber = CustomRandom.generateNumber(MIN, MAX);
    }
}
