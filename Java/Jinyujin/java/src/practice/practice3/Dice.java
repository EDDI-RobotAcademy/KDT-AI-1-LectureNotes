package practice.practice3;

import utility.random.CustomRandom;

// 주사위 만들기
public class Dice {
    final private int MIN_DICE_NUMBER = 1;
    final private int MAX_DICE_NUMBER = 6;

    int diceNumber2;

    public Dice() {
        diceNumber2 = CustomRandom.generateNumber(MIN_DICE_NUMBER, MAX_DICE_NUMBER);
    }

    @Override
    public String toString() {
        return "Dice{" +
                "diceNumber=" + diceNumber2 +
                '}';
    }
}
