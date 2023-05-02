package com.example.demo.lectureClass.homework.basic1.answer.problem2.dice;

import com.example.demo.lectureClass.utility.CustomRandom;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@RequiredArgsConstructor
public class Dice {

    final private static int MIN = 1;
    final private static int MAX = 6;
    final private int diceNumber;

    public Dice() {
        this.diceNumber = CustomRandom.generateNumber(MIN, MAX);
    }
}
