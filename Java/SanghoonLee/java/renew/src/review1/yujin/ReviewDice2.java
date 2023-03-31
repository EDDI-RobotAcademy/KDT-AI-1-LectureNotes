package review1.yujin;

import utility.random.CustomRandom;

public class ReviewDice2 {
    final int MAX_DICE_NUMBER = 6;
    final int MIN_DICE_NUMBER = 1;
    int diceNumber;
    public ReviewDice2() {
        diceNumber = CustomRandom.generateNumber(MAX_DICE_NUMBER, MIN_DICE_NUMBER);
    }
    @Override
    public String toString() {
        return "Dice{" +
                "diceNumber=" + diceNumber +
                '}';
    }
}
