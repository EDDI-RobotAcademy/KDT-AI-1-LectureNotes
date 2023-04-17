package problems.prob27;

import customLibrary.CustomRandom;

public class Dice {
    final int MIN_NUM = 1;
    final int MAX_NUM = 12;
    final int randomDiceNumber;

    public Dice(){
        this.randomDiceNumber = CustomRandom.generateNumber(MIN_NUM,MAX_NUM);
    }

    public int getRandomDiceNumber() {
        return randomDiceNumber;
    }

    @Override
    public String toString() {
        return "Dice{" +
                "randomDiceNumber=" + randomDiceNumber +
                '}';
    }
}
