package practice.dice2.dice2BackLog.dice;

import utility.random.CustomRandom;

public class Dice {
    final private int MIN_DICE_NUMBER = 1;
    final private int MAX_DICE_NUMBER = 6;
    final private int diceNumber;

    public int getDiceNumber() {
        return diceNumber;
    }

    public Dice() {
        diceNumber = CustomRandom.generateNumber(MIN_DICE_NUMBER, MAX_DICE_NUMBER);
    }

    @Override
    public String toString() {
        return '{' + "diceNumber=" + diceNumber +
                '}';
    }
}
