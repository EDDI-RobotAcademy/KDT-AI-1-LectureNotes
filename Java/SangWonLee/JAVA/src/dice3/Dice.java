package dice3;

import java.util.ArrayList;
import java.util.List;

public class Dice {
    int maxDice = 6;
    int minDice = 1;
    int diceNumber;


    public Dice() {
        this.diceNumber = CustomRandom.generateNumber(minDice,maxDice);
    }

    public Dice(int diceNumber) {
        this.diceNumber = diceNumber;
    }

    public int getDiceNumber() {
        return diceNumber;
    }
}
