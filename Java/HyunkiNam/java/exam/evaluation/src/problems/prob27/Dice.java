package problems.prob27;

import customLibrary.CustomRandom;

public class Dice {
    final int MIN_NUM = 1;
    final int MAX_NUM = 12;
    final int diceNumber;

    public Dice(){
        this.diceNumber = CustomRandom.generateNumber(MIN_NUM,MAX_NUM);
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
