package homework.third.diceGame4.component;

import utility.random.CustomRandom;

public class GameDice {
    final int MAX = 6;
    final int MIN = 1;
    final private int diceNumber;

    public GameDice(){
        this.diceNumber = CustomRandom.generateNumber(MIN,MAX);
    }

    public int getDiceNumber(){
        return diceNumber;
    }

    @Override
    public String toString() {
        return "GameDice{" +
                "diceNumber=" + diceNumber +
                '}';
    }
}
