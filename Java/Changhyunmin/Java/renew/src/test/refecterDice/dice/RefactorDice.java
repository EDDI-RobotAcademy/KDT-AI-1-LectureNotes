package test.refecterDice.dice;

import random.CustomRandom;

public class RefactorDice {
    final private int MIN = 1;
    final private int MAX = 6;
    final private int diceNumber;

    public RefactorDice(){
        this.diceNumber = CustomRandom.generateNumber(MIN,MAX);
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