package kr.eddi.demo.lectureClass.vue.controller.form;

import kr.eddi.demo.lectureClass.utility.random.CustomRandom;

public class Dice {
    final private int MAX = 6;
    final private int MIN = 1;
    final private int diceNumber;

    public Dice () {
        this.diceNumber = CustomRandom.generateNumber(MIN, MAX);
    }

    public int getDiceNumber() {
        return diceNumber;
    }

    @Override
    public String toString() {
        return "Dice{" +
                "diceNumber=" + diceNumber +
                '}';
    }
}
