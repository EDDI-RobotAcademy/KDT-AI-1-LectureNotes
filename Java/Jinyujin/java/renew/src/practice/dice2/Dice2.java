package practice.dice2;

import utility.random.CustomRandom;

public class Dice2 {
    final private int MIN_DICE_NUMBER = 1;
    final private int MAX_DICE_NUMBER = 6;
    final private int diceNumber;


    public int getDiceNumber() {
        return diceNumber;
    }

    public Dice2() {
        diceNumber = CustomRandom.generateNumber(MIN_DICE_NUMBER, MAX_DICE_NUMBER);
    }

    @Override
    public String toString() {
        return '{' + "diceNumber=" + diceNumber +
                '}';
    }
}
