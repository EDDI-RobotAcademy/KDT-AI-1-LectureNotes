package homework3.diceExampleSol.component;

public class Dice {
    final private static int DICE_MAX = 6;
    final private static int DICE_MIN = 1;
    final private int diceNumber;

    public Dice() {
        this.diceNumber = (int) (Math.random() * (DICE_MAX - DICE_MIN + 1) + DICE_MIN);
    }

    public int getDiceNumber() {
        return this.diceNumber;
    }

    @Override
    public String toString() {
        return "Dice{" +
                "diceNumber=" + diceNumber +
                '}';
    }
}

