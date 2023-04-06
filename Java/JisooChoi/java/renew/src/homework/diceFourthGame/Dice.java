package homework.diceFourthGame;

import utility.random.CustomRandom;
import java.util.ArrayList;

public class Dice {
    final public ArrayList<Integer> diceList = new ArrayList<>();

    final private int MAX = 6;
    final private int MIN = 1;

    public Dice() {}

    public int randomDice(){
        return CustomRandom.generateNumber(MIN, MAX);
    }

    @Override
    public String toString() {
        return "Dice{" +
                "diceList=" + diceList +
                '}';
    }
}
