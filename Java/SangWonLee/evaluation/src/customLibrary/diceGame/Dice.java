package customLibrary.diceGame;

import customLibrary.utility.random.CustomRandom;

public class Dice {

    final private int MIN = 1;
    final private int MAX = 12;
    private int diceNumber;

    public Dice() {
        this.diceNumber = CustomRandom.generateNumber(MIN, MAX);
    }

    public int getDiceNumber() {
        return diceNumber;
    }

    public void subtractDiceNumber() {
        diceNumber--;
    }

    @Override
    public String toString() {
        return "Dice{" +
                "diceNumber=" + diceNumber +
                '}';
    }
}