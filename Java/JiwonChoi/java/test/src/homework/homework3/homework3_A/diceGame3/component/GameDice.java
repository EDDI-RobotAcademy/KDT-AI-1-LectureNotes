package homework.homework3.homework3_A.diceGame3.component;

import utility.random.CustomRandom;

public class GameDice {
    final private  int MIN = 1; //주사위 최소값
    final private  int MAX = 6; //주사위 최대값
    final private int diceNumber; //주사위를 굴려 랜덤으로 나온 값

    public GameDice() {
        this.diceNumber = CustomRandom.generateNumber(MIN, MAX);
    }
    //GameDice()는 설정된 주사위랜덤값?
    public int getDiceNumber() {
        return  diceNumber;
    }

    @Override
    public String toString() {
        return  '\n' + "주사위를 굴렸습니다. " + diceNumber +
                "입니다";
    }
}
