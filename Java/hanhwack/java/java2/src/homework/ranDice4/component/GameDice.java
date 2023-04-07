package homework.ranDice4.component;

import utility.random.CustomRandom;

public class GameDice {
    final private int MIN = 1;
    final private int MAX = 6;
    final private  int diceNumber ;

    //생성자를 통해 1과 6사이의 랜덤 넘버 소환
    public GameDice() {
        this.diceNumber = CustomRandom.generateNumber(MIN, MAX);
    }

    // getter를 통해 diceNumber을 받아온다
    public int getDiceNumber() {
        return diceNumber;
    }

    // toString을 이용해서 받아온 diceNumber를 출력
    @Override
    public String toString() {
        return "GameDice{" +
                "diceNumber=" + diceNumber +
                '}';
    }
}
