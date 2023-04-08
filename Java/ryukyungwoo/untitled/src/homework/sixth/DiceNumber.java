package homework.sixth;

import utility.random.CustomRandom;

public class DiceNumber {
    final private int diceNumber;
    final private int MAX = 6;
    final private int MIN = 1;

    public DiceNumber () {
        this.diceNumber = CustomRandom.generateNumber(MIN, MAX);
    }
    public void getDiceNumber () {
        return.diceNumber;
    }

    @Override
    public String toString() {
        return "DiceNumber{" +
                "diceNumber=" + diceNumber +
                '}';
    }
}

