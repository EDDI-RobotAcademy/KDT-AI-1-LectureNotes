package customLibrary.diceGame.component;

import customLibrary.math.RandomGenerator;

public class Dice {
    final private int MAXDICENUMBER = 12;
    final private int MINDICENUMBER = 1;

    public int rollDice() {
        RandomGenerator randomGenerator = new RandomGenerator();
        return randomGenerator.randomInt(MINDICENUMBER, MAXDICENUMBER);
    }

}
