package practice.dice2.dice2BackLog.playGame;

import practice.dice2.dice2BackLog.dice.Dice;
import practice.dice2.dice2BackLog.score.Score;

import java.util.ArrayList;
import java.util.List;

public class PlayGame {

    final private List<Dice> diceList = new ArrayList<>();
    final private Score score;

    public PlayGame() {

        int diceSum = 0;

        for (int i = 0; i < 4; i++) {
            diceList.add(new Dice());
            diceSum += diceList.get(i).getDiceNumber();

            System.out.println("주사위 숫자: " + diceList.get(i).getDiceNumber());
        }
        this.score = new Score(diceSum);
        System.out.println("주사위 합: " + diceSum);
    }

    @Override
    public String toString() {
        return "PlayGame{" +
                "diceList=" + diceList +
                ", score=" + score +
                '}';
    }

    public boolean checkWin() {
        score.checkWin();

        return true;
    }
}
