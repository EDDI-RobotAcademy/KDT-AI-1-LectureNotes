package dicereview;

import utility.random.CustomRandom;

public class DiceRandom {
    private int MAX = 6;
    private int MIN = 1;
    private int diceNumber;

    public DiceRandom(int diceNumber) {
        this.diceNumber = CustomRandom.generateNumber(MAX,MIN);
    }

    public int getDiceNumber() {
        return diceNumber;
    }

    @Override
    public String toString() {
        return "diceNumber=" + diceNumber;
    }
}
