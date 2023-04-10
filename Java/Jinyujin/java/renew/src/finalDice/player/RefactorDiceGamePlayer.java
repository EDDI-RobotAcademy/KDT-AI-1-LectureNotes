package finalDice.player;

import finalDice.dice.RefactorDice;
import finalDice.score.RefactorScore;

import java.util.ArrayList;
import java.util.List;

public class RefactorDiceGamePlayer implements Comparable<RefactorDiceGamePlayer> {
    final private int MAX_DICE_NUM = 3;
    final private String name;
    final private List<RefactorDice> gameDiceList = new ArrayList<>();
    final private RefactorScore refactorScore;

    public RefactorDiceGamePlayer(String name) {
        this.name = name;

        int diceNumberSum = rollEveryDicesIfWeCan();
        refactorScore = new RefactorScore(diceNumberSum);
    }

    private int rollEveryDicesIfWeCan() {
        final int FIRST_DICE_INFO = 0;
        final int DECISION_EVEN = 2;
        final int ODD = 1;

        int diceNumberSum = 0;

        for (int i = 0; i < MAX_DICE_NUM; i++) {
            gameDiceList.add(new RefactorDice());

            diceNumberSum += gameDiceList.get(i).getDiceNumber();

            if (gameDiceList.get(FIRST_DICE_INFO).getDiceNumber() %
                    DECISION_EVEN == ODD) {
                break;
            }
        }

        return diceNumberSum;
    }

    public RefactorDice getSelectedGameDice(int index) {
        if (gameDiceList.size() > index) {
            return gameDiceList.get(index);
        }

        return null;
    }

    public RefactorScore getRefactorScore() {
        return refactorScore;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "RefactorPlayer{" +
                ", name='" + name + '\'' +
                ", gameDiceList=" + gameDiceList +
                ", gameScore=" + refactorScore +
                '}';
    }

    public RefactorScore getGameScore() {
        return refactorScore;
    }

    @Override
    public int compareTo(RefactorDiceGamePlayer otherPlayer) {
        // if 문으로 이기면 리턴1
        // 지면 리턴 -1
        // 무승부면 리턴 0 먼저 작성
        // if문 작성하고 변수에 대한 선언 필요 - (각자의 토탈스코어)
        // otherPlayerTotalScore를 구하기 위해 매개변수에 otherPlayer 넣어줌

        // 2.
        final int otherPlayerTotalScore = otherPlayer.getGameScore().getTotalScore();
        final int currentPlayerTotalScore = this.getGameScore().getTotalScore();

        // 1.
        if (otherPlayerTotalScore < currentPlayerTotalScore) {
            return 1;
        }
        if (otherPlayerTotalScore > currentPlayerTotalScore) {
            return -1;
        }
        return 0; // 무승부인 경우
    }
}
