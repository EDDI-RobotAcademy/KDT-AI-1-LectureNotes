package jdp1.entity;

import utility.random.CustomRandom;

public class Dice {
    final private int MIN_DICE = 1;
    final private int MAX_DICE = 6;
    private int diceNumber;

    public Dice () {
        this.diceNumber = CustomRandom.generateNumber(MIN_DICE, MAX_DICE);
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
