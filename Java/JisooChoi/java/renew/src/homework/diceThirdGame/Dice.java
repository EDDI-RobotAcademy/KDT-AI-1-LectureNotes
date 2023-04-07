package homework.diceThirdGame;

import utility.random.CustomRandom;

import java.util.Arrays;

public class Dice {
    final public int[] diceArray = new int[3];
    final private int MAX = 6;
    final private int MIN = 1;

    public Dice() {}

    public int randomDice(){
        return CustomRandom.generateNumber(MIN, MAX);
    }

    @Override
    public String toString() {
        return "Dice{" +
                "diceArray=" + Arrays.toString(diceArray) +
                '}';
    }
}
