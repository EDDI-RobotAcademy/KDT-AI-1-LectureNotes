package homework.sixth;

import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class Dice {
    final private int MAX_DICE_NUM = 6;
    final private int MIN_DICE_NUM = 1;
    final private int HOW_MANY_DICES = 3;
    private int diceNumber;
    List<Dice> diceList = new ArrayList<>();
    public Dice(int diceNumber) {
        this.diceNumber = diceNumber;
    }
    public Dice () {
        for (int i = 0; i < HOW_MANY_DICES; i++) {
            this.diceNumber = CustomRandom.generateNumber(MIN_DICE_NUM, MAX_DICE_NUM);
            diceList.add(new Dice(diceNumber));
        }
    }

    public List<Dice> getDiceList() {
        return diceList;
    }

    @Override
    public String toString() {
        return "Dice{" +
                "diceList=" + diceList +
                '}';
    }

    public static void main(String[] args) {
        Dice dice = new Dice();
        System.out.println(dice.diceList);
    }


}
