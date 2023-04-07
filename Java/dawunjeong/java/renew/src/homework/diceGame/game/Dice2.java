package homework.diceGame.game;

import utility.random.CustomRandom;

// 주사위의 값 하나를 갖고 있는 클래스
public class Dice2 {
    final private int MIN = 1;
    final private int MAX = 6;
    final private int diceNumber;

    public Dice2() {
        this.diceNumber = CustomRandom.generateNumber(MIN,MAX);
    }

    public int getDiceNumber(int index) {
        return diceNumber;
    }

    @Override
    public String toString() {
        return "Dice2{" +
                "diceNumber=" + diceNumber +
                '}';
    }
}
