package jdp1;

import utility.random.CustomRandom;

public class Dice {
    final private int MAX_NUMBER = 6;
    final private int MIN_NUMBER = 1;
    private int diceNumber;

    public Dice() {
        diceNumber = CustomRandom.generateNumber(MIN_NUMBER, MAX_NUMBER);
    }

    public int getDiceNumber() {
        return diceNumber;
    }

    @Override
    public String toString() {
        return "dice{" +
                "diceNumber=" + diceNumber +
                '}';
    }
}
