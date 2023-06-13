package com.example.demo.exam.exam4.entity;

import com.example.demo.utility.random.CustomRandom;
import lombok.Getter;

@Getter
public class Dice {
    private int diceNumber;
    final private int MIN = 1;
    final private int MAX = 6;

    public Dice () {
        diceNumber = CustomRandom.generateNumber(MIN, MAX);
    }
}
