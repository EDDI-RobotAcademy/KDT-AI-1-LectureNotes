package practice.practice2;

import java.util.ArrayList;
import java.util.List;

public class Game {

    // 주사위 가져와서 4개 굴리기 - for 문 이용
    final private int MAX_DICE = 4;
    List<Dice> diceList = new ArrayList<>();
    private int diceSum = 0;
    // 스코어 클래스에서 만든 totalSum에 대한 정보를 여기로 가져오자
    private Score score;

    public Game() {

        for (int i = 0; i < MAX_DICE; i++) {
            diceList.add(new Dice());
            diceSum += diceList.get(i).diceNumber;
        }
        score = new Score(diceSum);
    }

    public void checkWin() {
        score.checkWinByScore();
    }

    @Override
    public String toString() {
        return "Game{" +
                "diceList=" + diceList +
                '\n' + "diceSum=" + diceSum +
                '}';
    }
}
