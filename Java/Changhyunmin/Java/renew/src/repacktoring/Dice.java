package repacktoring;

import random.CustomRandom;

class Dice {
    final private int MIN = 1;
    final private int MAX = 6;
    private int DiceNumber;

    public Dice(int i) {
        DiceNumber = CustomRandom.generateNumber(MIN, MAX);
    }

    public int getDiceNumber() {
        return DiceNumber;
    }

    @Override
    public String toString() {
        return "Dice{" +
                "DiceNumber=" + DiceNumber +
                '}';
    }
}
