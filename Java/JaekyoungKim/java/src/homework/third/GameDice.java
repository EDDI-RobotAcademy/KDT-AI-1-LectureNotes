package homework.third;

public class GameDice {
    final private int MIN = 1;
    final private int MAX = 6;
    final private int diceNumber;
    public GameDice() {
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

