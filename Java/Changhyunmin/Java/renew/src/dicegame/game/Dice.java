package dicegame.game;

import random.CustomRandom;

public class Dice {
    final private int MIN = 1;
    final private int MAX = 6;
    final private int diceNumber;

    public Dice() {
        this.diceNumber = CustomRandom.generateNumber(MIN, MAX);
    }

    public int getDiceNumber() {
        return diceNumber;
    }

    @Override
    public String toString() {
        return "주사위 값: " + diceNumber;
    }
}
