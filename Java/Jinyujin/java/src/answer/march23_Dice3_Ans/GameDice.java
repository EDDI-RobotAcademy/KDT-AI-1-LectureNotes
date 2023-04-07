package answer.march23_Dice3_Ans;


import utility.random.CustomRandom;

public class GameDice {
    // 이건 미리 만들어 놓은 것 가져오면 된다

    private int diceNumber;
    final private int MIN = 1;
    final private int MAX = 6;

    public GameDice() {
        this.diceNumber = CustomRandom.generateNumber(MIN, MAX);
    }

    public int getDiceNumber() {
        return diceNumber;
    }

    @Override
    public String toString() {
        return "GameDice{" +
                "diceNumber=" + diceNumber +
                '}';
    }
}
