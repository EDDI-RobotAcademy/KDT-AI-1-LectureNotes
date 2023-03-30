package writerForm.diceGame;

import utility.random.CustomRandom;

public class DiceDice {

    final private int MAX = 6;
    final private int MIN = 1;
    int randomDice;

    public DiceDice(){}

    public int rollDie() {
        // 플레이어가 주사위를 굴린다.
        return randomDice = CustomRandom.generateNumber(MIN, MAX);
    }

    public int getRandomDice() {
        return randomDice;
    }


    public void setRandomDice(int randomDice) {
        this.randomDice = randomDice;
    }
}
