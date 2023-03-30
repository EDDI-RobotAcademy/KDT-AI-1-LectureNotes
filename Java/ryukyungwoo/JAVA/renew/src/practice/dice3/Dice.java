package practice.dice3;

import utility.random.CustomRandom;

public class Dice {

    final private int MAX_DICE_NUM = 6;
    final private int MIN_DICE_NUM = 1;
    final private int diceNumber;
    public Dice () {
        this.diceNumber =
        CustomRandom.generateNumber(MIN_DICE_NUM, MAX_DICE_NUM);
    }

    public int getDiceNumber() {
        return diceNumber;
    }

    public static void main(String[] args) {
    }
}
