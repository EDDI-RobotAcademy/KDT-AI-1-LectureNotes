package kr.eddi.demo.lectureClass.vue.controller.form;

import java.util.ArrayList;

public class DiceList {
    final private int HOW_MANY_DICES = 3;
    ArrayList<Integer> diceList = new ArrayList<>();

    public DiceList () {
        Dice dice = new Dice();
        for (int i = 0; i < HOW_MANY_DICES; i++) {
            diceList.add(dice.getDiceNumber());
            if (diceList.get(0) % 2 != 0 ) {
                break;
            }
        }
    }

    public ArrayList<Integer> getDiceList() {
        return diceList;
    }

    @Override
    public String toString() {
        return "DiceList{" +
                "diceList=" + diceList +
                '}';
    }
}
