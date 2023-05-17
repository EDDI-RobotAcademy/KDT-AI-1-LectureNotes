package finalDice.dice;

import utility.random.CustomRandom;

// 다이스부분은 전과 동일 이름만 변경됨
public class RefactorDice {
    private int MAX = 6;
    private int MIN = 1;
    private int diceNumber;

    public RefactorDice() {
        this.diceNumber = CustomRandom.generateNumber(MAX,MIN);
    }

    public int getDiceNumber() {
        return diceNumber;
    }

    @Override
    public String toString() {
        return "diceNumber=" + diceNumber;
    }
}