package practice.dice3.diceGame3BackLogPractice3.player;

import practice.dice3.diceGame3BackLogPractice3.dice.Dice;
import practice.dice3.diceGame3BackLogPractice3.score.GameScore;

import java.util.ArrayList;
import java.util.List;

public class Player {

    final private String name;
    final private int DICE_MAX = 3;
    final private List<Dice> diceList = new ArrayList<>();
    final private GameScore gameScore;

    public String getName() {
        return name;
    }

    public GameScore getGameScore() {
        return gameScore;
    }

    public Player(String name) {
        this.name = name;

        int diceSum = rollDice();
        gameScore = new GameScore(diceSum);
    }

    public int rollDice() {

        int diceSum = 0;

        final int FIRST_DICE_INFO = 0;
        final int EVEN = 2;
        final int ODD = 1;

        for (int i = 0; i < DICE_MAX; i++) {
            diceList.add(new Dice());
            // Dice의 생성자와 연결되는 것
            diceSum += diceList.get(i).getDiceNumber();

            // 주사위 여기서 하나 굴릴지 3개 굴릴지 정하니까 여기서 첫 번째 주사위 조건 걸어줘야함
            // 여기서는 하나 굴리는 케이스, 3개 굴리는 케이스만 정함
            // 그래서 이걸 게임매니저에서 불러서 작동하는 것
            if (diceList.get(FIRST_DICE_INFO).getDiceNumber() % EVEN == ODD) {
                break;
            }
        }
        return diceSum;
    }

    public Dice needToSelectDice(int diceIdx) {

        if (diceList.size() < diceIdx + 1) {
            return null;
        }
        // GameManager와 연결된 것
        // 지금 주사위가 1개인 경우와 3개인 경우가 있음
        // 나는 diceIdx를 2를 넣어줄 것
        // 이것은 지금 완벽하게 이해하기 힘든 것 같음 나중에 받아들이자

        return diceList.get(diceIdx);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", diceList=" + diceList +
                ", gameScore=" + gameScore +
                '}';
    }
}
