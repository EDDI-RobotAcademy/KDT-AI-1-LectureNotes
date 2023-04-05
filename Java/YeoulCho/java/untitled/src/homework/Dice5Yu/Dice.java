package homework.Dice5Yu;

import utility.random.CustomRandom;

public class Dice {
    final int MAX = 6;
    final int MIN = 1;
    int diceNumber;

    public Dice() {

    }

    public int getDiceNumber() {
        return diceNumber;
    }

    public int randomDiceNumber(){

        diceNumber = CustomRandom.generateNumber(MIN,MAX);
        return diceNumber;
    }

    @Override
    public String toString() {
        return "Dice{" +
                "dice=" + diceNumber +
                '}';
    }
}
