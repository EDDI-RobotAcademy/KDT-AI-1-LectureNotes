package practice.dice3BackLog2.player;

import practice.dice3BackLog2.dice.Dice;
import practice.dice3BackLog2.score.Score;

import java.util.ArrayList;
import java.util.List;

public class Player {

    final private String name;
    final private List<Dice> diceList = new ArrayList<>();
    private Score score;

    public Player(String name) {
        this.name = name;
        this.score = score;

        score = new Score(rollDice());
    }

    public int rollDice() {
        final int DICE_NUMBER = 3;

        final int FIRST_DICE_NUMBER = 0;
        final int EVEN = 2;
        final int ODD = 1;

        int diceSum = 0;

        for (int i = 0; i < DICE_NUMBER; i++) {
            diceList.add(new Dice());
            diceSum += diceList.get(i).getDiceNumber();

            if (diceList.get(FIRST_DICE_NUMBER).getDiceNumber() % EVEN == ODD) {
                break;
            }
        }

        return diceSum;
    }

    public Dice needToSelectDice(int diceIdx) {
        // 세번째 주사위를 선택하기 위한 메서드

        if (diceList.size() < diceIdx + 1) {
            return null;
        }

        return diceList.get(diceIdx);
    }


    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", diceList=" + diceList +
                ", score=" + score +
                '}';
    }

    public Score getTotalScore() {

        return score;
    }
}
