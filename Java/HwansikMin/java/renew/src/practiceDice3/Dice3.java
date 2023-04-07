package practiceDice3;

import utility.random.CustomRandom;

public class Dice3 {
    // 최소 최대 숫자 1~6
    // 랜덤 메서드
    // 나온값 저장
    final int MIN = 1;
    final int MAX = 6;
    int DiceNumber;
    public Dice3 () {
        this.DiceNumber = CustomRandom.generateNumber(MIN, MAX);
    }

    public int getDiceNumber() {
        return DiceNumber;
    }
}
