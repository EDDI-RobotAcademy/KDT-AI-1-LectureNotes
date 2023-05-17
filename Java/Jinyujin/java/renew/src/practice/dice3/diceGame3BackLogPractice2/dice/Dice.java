package practice.dice3.diceGame3BackLogPractice2.dice;

import utility.random.CustomRandom;

public class Dice {

    final private int MIN_DICE_NUMBER = 1;
    final private int MAX_DICE_NUMBER = 6;

    int randomDiceNumber = CustomRandom.generateNumber(MIN_DICE_NUMBER, MAX_DICE_NUMBER);

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
