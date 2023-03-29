package homework.sixth;

import utility.random.CustomRandom;

public class DiceNumber {
    final private int diceNumber;
    final private int MAX = 6;
    final private int MIN = 1;

    DiceNumber () {
        this.diceNumber = CustomRandom.generateNumber(MIN, MAX);
    }
}
