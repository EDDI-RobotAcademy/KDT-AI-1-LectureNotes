package practice.practice2;

import java.util.ArrayList;
import java.util.List;

public class Game {

    // 주사위 가져와서 4개 굴리기 - for 문 이용
    final int MAX_DICE = 4;
    List<Dice> diceList = new ArrayList<>();
    final private Score score;

    public Game() {
        int diceSum = 0;

        for (int i = 0; i < MAX_DICE; i++) {
            diceList.add(new Dice());
            diceSum += diceList.get(i).diceNumber;
        }

        score = new Score(diceSum);
    }

    public Boolean checkWin () {
        return score.checkWin();
    }

    @Override
    public String toString() {
        return "Game{" +
                "diceList=" + diceList +
                ", score=" + score +
                '}';
    }
}
