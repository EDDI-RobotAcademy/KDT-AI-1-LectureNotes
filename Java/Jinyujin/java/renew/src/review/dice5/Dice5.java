package review.dice5;

import utility.random.CustomRandom;

// 주사위 클래스
// 랜덤으로 1~6까지 나오는 주사위 만들기
// 단순히 주사위만 돌린다는 생각
public class Dice5 {
    final private int MIN_DICE_NUMBER = 1;
    final private int MAX_DICE_NUMBER = 6;
    final private int diceNumber;

    public int getDiceNumber() {
        return diceNumber;
    }

    public Dice5() {
        diceNumber = CustomRandom.generateNumber(MIN_DICE_NUMBER, MAX_DICE_NUMBER);
    }

    @Override
    public String toString() {
        return "diceNumber=" + diceNumber +
                '}';
    }
}
