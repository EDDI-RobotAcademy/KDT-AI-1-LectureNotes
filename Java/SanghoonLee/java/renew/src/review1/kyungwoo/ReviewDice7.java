package review1.kyungwoo;

import utility.random.CustomRandom;

public class ReviewDice7 {

    final private int diceNumber;

    public ReviewDice7() {
        final int MIN = 1;
        final int MAX = 6;

        this.diceNumber = CustomRandom.generateNumber(MIN, MAX);
    }

    @Override
    public String toString() {
        return "ReviewDice7{" +
                "diceNumber=" + diceNumber +
                '}';
    }
}
