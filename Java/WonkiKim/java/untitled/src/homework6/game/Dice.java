package homework6.game;

public class Dice {
    private int diceNumber;

    public int getDiceNumber() {
        return diceNumber;
    }

    public void roll() {
        diceNumber = utility.random.CustomRandom.generateNumber(1, 6);
    }

    @Override
    public String toString() {
        return "Dice{" +
                "diceNumber=" + diceNumber +
                '}';
    }
}
