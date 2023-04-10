package customLibrary;

public class RefactorDice {
    final private int MIN = 1;
    final private int MAX = 12;
    final private int diceNumber;

    public RefactorDice() {
        this.diceNumber = RandomGenerator.generateNumber(MIN, MAX);
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
