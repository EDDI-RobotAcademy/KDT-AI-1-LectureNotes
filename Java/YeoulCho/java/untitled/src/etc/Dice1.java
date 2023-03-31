package etc;

import utility.random.CustomRandom;

public class Dice1 {

    int randomDice;


    public int randomDice(){
        final int MIN = 1;
        final int MAX =6;
        randomDice = CustomRandom.generateNumber(MIN,MAX);
        return randomDice;

    }

    public int getRandomDice() {
        return randomDice();
    }
}
