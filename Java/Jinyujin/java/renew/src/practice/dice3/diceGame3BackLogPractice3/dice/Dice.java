package practice.dice3.diceGame3BackLogPractice3.dice;

import utility.random.CustomRandom;

public class Dice {

    final private int MIN_DICE = 1;
    final private int MAX_DICE = 6;

    final private int diceNumber;

    public int getDiceNumber() {
        return diceNumber;
    }
    // private 붙어있을 때 다른데서 사용하려면 일단 getter 만들어놓기

    public Dice() {
        this.diceNumber = CustomRandom.generateNumber(MIN_DICE, MAX_DICE);
    }
    // 생성자로 만들어 놓으면 다른 클래스에서 부름과 동시에 이렇게 정해지도록

    @Override
    public String toString() {
        return "Dice{" +
                "diceNumber=" + diceNumber +
                '}';
    }
}
