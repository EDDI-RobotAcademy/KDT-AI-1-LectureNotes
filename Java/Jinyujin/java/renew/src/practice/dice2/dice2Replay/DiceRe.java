package practice.dice2.dice2Replay;

import utility.random.CustomRandom;
// 여기선 주사위 수만 출력 가능하게
public class DiceRe {
    private int diceNumber;
    final private int MIN_DICE_NUMBER = 1; // 자동복붙 단축키: Ctrl + D
    final private int MAX_DICE_NUMBER = 6;

    public DiceRe() {
        diceNumber = CustomRandom.generateNumber(MIN_DICE_NUMBER, MAX_DICE_NUMBER);
    }

    public int getDiceNumber() {
        return diceNumber;
    }

    @Override
    public String toString() {
        return '{' + "diceNumber=" + diceNumber +
                '}';
    }
}
