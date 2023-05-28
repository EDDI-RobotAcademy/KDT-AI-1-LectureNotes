package practice.dice3BackLog2.dice;

import utility.random.CustomRandom;

public class Dice {

    final private int MAX_DICE_NUMBER = 6;
    final private int MIN_DICE_NUMBER = 1;
    int diceNumber = CustomRandom.generateNumber(MIN_DICE_NUMBER, MAX_DICE_NUMBER);

    public int getDiceNumber() {
        return diceNumber;
    }

    @Override
    public String toString() {
        return "{" +
                "diceNumber=" + diceNumber +
                '}';
    }
}
