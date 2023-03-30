package practice.dice3;

import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class Dice {

    final private int MAX_DICE_NUM = 6;
    final private int MIN_DICE_NUM = 1;
    final private int HOW_MANY_ROLL_DICE= 3;
    List<Integer> diceList = new ArrayList<>();
    public Dice () {
        for (int i = 0; i < HOW_MANY_ROLL_DICE; i++) {
            this.diceList.add(CustomRandom.generateNumber(MIN_DICE_NUM, MAX_DICE_NUM));
        }
    }

    @Override
    public String toString() {
        return "Dice{" +
                "diceList=" + diceList +
                '}';
    }

    public static void main(String[] args) {
        System.out.println(new Dice());
    }
}
