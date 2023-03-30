package homework.diceThirdGame;

import utility.random.CustomRandom;

public class DiceDice {
    final private int MAX = 6;
    final private int MIN = 1;
    int diceReturn;

    public DiceDice(){
    }

    public int randomDice(){
        return diceReturn = CustomRandom.generateNumber(MIN, MAX);
    }

    public int getDiceReturn() {
        return diceReturn;
    }
}
