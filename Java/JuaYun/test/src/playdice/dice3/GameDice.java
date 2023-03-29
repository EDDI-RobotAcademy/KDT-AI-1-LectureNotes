package playdice.dice3;

import utility.CustomRandom;

public class GameDice {
    final private int MIN = 1;
    final private int MAX = 6;
    final private int diceNumber;

    public GameDice(int diceNumber) {
        this.diceNumber = CustomRandom.generateNumber(MIN,MAX);
    }    // 랜덤으로 굴리는것까지 작성

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