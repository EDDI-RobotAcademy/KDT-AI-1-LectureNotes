package practice1;

import utility.random.CustomRandom;

public class Dice { //주사위라는 객체에 랜덤다이스존재
    final int MIN = 1;
    final int MAX = 6;
    private int diceNumber;


    public Dice() { //Dice 생성자 생성
        this.diceNumber = CustomRandom.generateNumber(MIN,MAX);
    } //다이스 객체의 랜덤다이스는 커스텀랜덤을 통해 만듬

    public int getDiceNumber() { //다이스객체에서 다이스의 숫자를 가져오는 메서드
        return diceNumber;
    }

    @Override
    public String toString() { // 다이스 객체 중 다이스의 숫자를 toString
        return "Dice{" +
                "diceNumber=" + diceNumber +
                '}';
    }
}
