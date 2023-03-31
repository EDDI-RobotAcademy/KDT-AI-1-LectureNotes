package homework.sixth.component;

import utility.random.CustomRandom;

public class GameDice {
    final int MIN = 1;
    final int MAX = 6;
    int diceNumber;
    public GameDice(){
        this.diceNumber = CustomRandom.generateNumber(MIN,MAX);;
    }

    public int getDiceNumber() {
        return diceNumber;
    }

    @Override
    public String toString() {
        return Integer.toString(diceNumber);

    }

    public void setDiceNumber(int diceNumber) {
        this.diceNumber = diceNumber;
    }
}
