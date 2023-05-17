package com.example.demo.problem4Dice.entity;

import random.CustomRandom;

public class Problem4Dice {
    final private int DICE_MAX_NUMBER = 6;
    final private int DICE_MIN_NUMBER = 1;

    private int diceNumber;

    public Problem4Dice () {
        diceNumber = CustomRandom.generateNumber(DICE_MIN_NUMBER, DICE_MAX_NUMBER);
    }

    public int getDiceNumber() {
        return diceNumber;
    }
}
