package homework.Dice3;

import utility.random.CustomRandom;

// 주사위 클래스
// 1 - 6까지 랜덤 생성 - CustomRandom 이용
public class Dice {

    int diceNumber;

    public int getDiceNumber() {
        return diceNumber;
    }

    public Dice() {
        diceNumber = CustomRandom.generateNumber(1, 6);
    }

    @Override
    public String toString() {
        return "Dice{" +
                "diceNumber=" + diceNumber +
                '}';
    }
}
