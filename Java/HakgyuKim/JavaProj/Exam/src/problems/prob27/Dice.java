package problems.prob27;

import customLibrary.CustomRandom;

public class Dice {
    final private int DICE_MAX = 12;
    final private int DICE_MIN = 1;
    final private int diceNum;

    public Dice() {
        diceNum = CustomRandom.generateNumber(DICE_MIN, DICE_MAX);
    }

    public int getDiceNum() {
        return diceNum;
    }
}
