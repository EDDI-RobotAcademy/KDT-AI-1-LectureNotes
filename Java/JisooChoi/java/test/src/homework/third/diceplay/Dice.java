package homework.third.diceplay;

public class Dice {
    final private int MAX = 6;
    final private int MIN = 1;
    int diceNumber;

    public Dice() {
        this.diceNumber = (int) (Math.random() * MAX) + MIN;
    }
}
