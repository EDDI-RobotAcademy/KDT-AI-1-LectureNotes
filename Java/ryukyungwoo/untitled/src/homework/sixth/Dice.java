package homework.sixth;

import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class Dice {
    final private int MAX_DICE_NUM = 6;
    final private int MIN_DICE_NUM = 1;
    final private int HOW_MANY_DICES = 3;
    final private int diceNumber;
    List<Dice> diceList = new ArrayList<>();

    public Dice () {

        this.diceNumber = CustomRandom.generateNumber(MIN_DICE_NUM, MAX_DICE_NUM);
        for (int i = 0; i < HOW_MANY_DICES; i++) {
            diceList.add(new Dice(diceNumber));
        }
    }

//    for (int i = 0; i < HOW_MANY_DICES; i++) {
//        diceList.add(CustomRandom.generateNumber(MIN_DICE_NUM, MAX_DICE_NUM));
//    }
//    이 방식은 왜 안되는지


    public Dice(int dice) {
        this.diceNumber = dice;
    }
    @Override
    public String toString() {
        return "Dice{" +
                "dice=" + diceNumber +
                '}';
    }

    public static void main(String[] args) {
        Dice dice = new Dice();
        System.out.println(dice.diceList);
    }


}
