package 주사위_5번_문제.finalDice.player;

import 주사위_5번_문제.finalDice.dice.RefactorDice;
import 주사위_5번_문제.finalDice.score.RefactorScore;

import java.util.ArrayList;
import java.util.List;

public class RefactorDiceGamePlayer implements Comparable<RefactorDiceGamePlayer> {
    final private int MAX_DICE_NUM = 3;
    final private String name;
    final private List<RefactorDice> diceList = new ArrayList<>();
    final private RefactorScore gameScore;

    public RefactorDiceGamePlayer(String name) {
        this.name = name;

        int diceNumberSum = rollEveryDicesIfWeCan();
        gameScore = new RefactorScore(diceNumberSum); // 생성자
    } // 플레이어 클래스에는 이름과 주사위 숫자 합, 스코어가 있다.

    private int rollEveryDicesIfWeCan() {
        final int FIRST_DICE_INFO = 0;
        final int DECISION_EVEN = 2;
        final int ODD = 1;

        int diceNumberSum = 0;

        for (int i = 0; i < MAX_DICE_NUM; i++) {
            diceList.add(new RefactorDice());

            diceNumberSum += diceList.get(i).getDiceNumber();

            if (diceList.get(FIRST_DICE_INFO).getDiceNumber() %
                    DECISION_EVEN == ODD) {
                break;
            }
        }

        return diceNumberSum;
    }

    public RefactorDice getSelectedGameDice(int index) {
        if (diceList.size() > index) {
            return diceList.get(index);
        }

        return null;
    }

    public RefactorScore getGameScore() {
        return gameScore;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", gameDiceList=" + diceList +
                ", gameScore=" + gameScore +
                '}';
    }

    @Override
    public int compareTo(RefactorDiceGamePlayer otherPlayer) {
        final int otherPlayerTotalScore = otherPlayer.getGameScore().getTotalScore();
        final int currentPlayerTotalScore = this.getGameScore().getTotalScore();

        if (otherPlayerTotalScore < currentPlayerTotalScore) {
            return 1;
        } else if (otherPlayerTotalScore > currentPlayerTotalScore) {
            return -1;
        }

        return 0;
    }
}