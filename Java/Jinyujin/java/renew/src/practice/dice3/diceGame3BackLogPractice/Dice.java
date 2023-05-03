package practice.dice3.diceGame3BackLogPractice;

import utility.random.CustomRandom;

public class Dice {
    // 주사위 만들기
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
