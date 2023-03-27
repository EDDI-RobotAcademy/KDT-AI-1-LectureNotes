package homework.thirdSolution.component;

import utility.random.CustomRandom;
public class GameDice {
    final private int MIN = 1;
    final private int MAX = 6;
    final private int diceNumber;

    public GameDice() {
        this.diceNumber = CustomRandom.generateNumber(MIN, MAX);
    }

    public int getDiceNumber() {
        return diceNumber;
    }

    @Override
    public String toString() {
        return "Dice{" +
                "diceNumber=" + diceNumber +
                '}';
    }
}
