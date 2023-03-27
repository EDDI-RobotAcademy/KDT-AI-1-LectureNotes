package HomeWork.DiceGame.component;

public class GameDice {
    final private int MIN = 1;
    final private int MAX = 6;
    final private int diceNumber;

    public GameDice() {
        this.diceNumber = Custom_Random.generateNumber(MIN, MAX);
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
