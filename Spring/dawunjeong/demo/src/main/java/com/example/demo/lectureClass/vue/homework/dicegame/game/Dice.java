package com.example.demo.lectureClass.vue.homework.dicegame.game;

import com.example.demo.lectureClass.untility.random.CustomRandom;

public class Dice {
    final private int MIN = 1;
    final private int MAX = 6;
    final private int diceNumber;

    public Dice() {
        this.diceNumber = CustomRandom.generateNumber(MIN, MAX);
    }

    public int getDiceNumber() {
        return diceNumber;
    }

    @Override
    public String toString() {
        return "Dice{" +
                "diceNumber=" + diceNumber +
                '}';
    }
}
