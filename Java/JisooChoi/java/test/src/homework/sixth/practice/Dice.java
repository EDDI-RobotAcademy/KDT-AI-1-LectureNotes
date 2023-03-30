package homework.sixth.practice;

import utility.random.CustomRandom;

public class Dice {
    // 주사위는 3개가 최대로 만들어지는데, 1 ~ 6까지 랜덤의 수로 만들어지며, 이 값은 누적된다.
    // [] -> [] -> []
    final private int MAX = 6;
    final private int MIN = 1;
    // 랜덤으로 만들어진 주사위가 있을 변수 명 선언해주기
    private int diceNum;

    public Dice(){
        this.diceNum = (CustomRandom.generateNumber(MIN, MAX));
    }

    public int getDiceNum() {
        return diceNum;
    }

    public void setDiceNum(int diceNum) {
        this.diceNum = diceNum;
    }

    @Override
    public String toString() {
        return "Dice{" +
                "diceNum=" + diceNum +
                '}';
    }
}
