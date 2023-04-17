package com.example.demo.lectureClass.homework.problem2dot2;


import com.example.demo.lectureClass.utility.random.CustomRandom;

public class GameDice {
    final private int MIN = 1;
    final private int MAX = 6;
    final private int diceNumber;

    public GameDice() {
        this.diceNumber = CustomRandom.generateNumber(MIN, MAX);
    }

    public int getDiceNumber() {
        return diceNumber;
    }


}
