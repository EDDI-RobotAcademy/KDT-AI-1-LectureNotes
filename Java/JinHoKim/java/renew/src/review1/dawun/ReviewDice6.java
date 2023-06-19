package review1.dawun;

import utility.random.CustomRandom;

public class ReviewDice6 {
    final private int MIN = 1;
    final private int MAX = 6;
    final private int diceNumber;

    public ReviewDice6() {
        this.diceNumber = CustomRandom.generateNumber(MIN,MAX);
    }

    public int getDiceNumber(int index) {
        return diceNumber;
    }

    @Override
    public String toString() {
        return "Dice2{" +
                "diceNumber=" + diceNumber +
                '}';
    }
}
