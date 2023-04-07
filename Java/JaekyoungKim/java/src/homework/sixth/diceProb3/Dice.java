package homework.sixth.diceProb3;

public class Dice {
    final private int MIN = 1;
    final private int MAX = 6;
    final private int diceNumber;
    public Dice() {
        this.diceNumber = (int) (Math.random() * (MAX - MIN + 1)) + MIN;
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

