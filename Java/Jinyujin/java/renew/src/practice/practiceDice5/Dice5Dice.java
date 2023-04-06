package practice.practiceDice5;

import utility.random.CustomRandom;

// 주사위 만들기 고수
public class Dice5Dice {
    private int diceNumber;
    final private int MIN_DICE_NUMBER = 1;
    final private int MAX_DICE_NUMBER = 6;

    public Dice5Dice() {
        diceNumber = CustomRandom.generateNumber(MIN_DICE_NUMBER, MAX_DICE_NUMBER);
    }

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
