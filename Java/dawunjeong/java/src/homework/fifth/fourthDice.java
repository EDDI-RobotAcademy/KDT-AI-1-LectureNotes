package homework.fifth;
import utility.random.CustomRandom;

public class fourthDice {

    final int MIN = 1;
    final int MAX = 6;
    final int diceNumber;

    public fourthDice() {
        this.diceNumber = CustomRandom.generateNumber(MIN,MAX);
    }

    public int getDiceNumber() {
        return diceNumber;
    }
    @Override
    public String toString() {
        return "Dice [diceNumber=" + diceNumber + "]";
    }
}