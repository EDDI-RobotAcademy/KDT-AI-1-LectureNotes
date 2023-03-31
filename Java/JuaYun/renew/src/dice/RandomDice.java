package diceTest;

import utility.random.CustomRandom;

import java.util.Currency;

public class RandomDice {
    final private int MAX = 6;
    final private int MIN = 1;

    final private int diceNumber;

    public RandomDice() {
        this.diceNumber = CustomRandom.generateNumber(MAX, MIN);
    }

    public int getDiceNumber() {
        return diceNumber;
    }
}