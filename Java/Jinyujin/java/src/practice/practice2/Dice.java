package practice.practice2;

import utility.random.CustomRandom;

public class Dice {
    // 주사위 랜덤 숫자 부여 - CustomRandom

    final int MAX_DICE_NUMBER = 6;
    final int MIN_DICE_NUMBER = 1;
    int diceNumber;

    public Dice() {
        diceNumber = CustomRandom.generateNumber(MAX_DICE_NUMBER, MIN_DICE_NUMBER);
    }

    @Override
    public String toString() {
        return "Dice{" +
                "diceNumber=" + diceNumber +
                '}';
    }
}
