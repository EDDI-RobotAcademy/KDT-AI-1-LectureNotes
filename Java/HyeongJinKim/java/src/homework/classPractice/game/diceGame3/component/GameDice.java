package homework.classPractice.game.diceGame3.component;

import utility.random.CustomRandom;

public class GameDice {
    final int MIN = 1;
    final int MAX = 6;
    final int diceNumber;

    public GameDice() {
        this.diceNumber = CustomRandom.generateNumber(MIN, MAX);
    }
    public int getDiceNumber() {
        return this.diceNumber;
    }

    @Override
    public String toString() {
        return "GameDice{" +
                "diceNumber=" + diceNumber +
                '}';
    }
}
