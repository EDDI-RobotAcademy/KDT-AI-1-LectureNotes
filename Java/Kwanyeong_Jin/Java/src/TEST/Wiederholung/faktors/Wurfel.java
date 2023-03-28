package TEST.Wiederholung.faktors;

import utility.random.CustomRandom;

public class Wurfel {
    final private int MIN = 1;
    final private int MAX = 6;
    final private int WurfelNum;

    public Wurfel() {
        this.WurfelNum = CustomRandom.generateNumber(MIN, MAX);
    }

    public int bekommwurflNum() {
        return WurfelNum;
    }

    @Override
    public String toString() {
        return "Dice{" +
                "diceNumber=" + WurfelNum +
                '}';
    }
}