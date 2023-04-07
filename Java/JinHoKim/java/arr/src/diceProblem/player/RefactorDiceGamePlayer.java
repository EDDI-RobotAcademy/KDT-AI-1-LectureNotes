package diceProblem.player;

import diceProblem.dice.RefactorDice;
import diceProblem.score.RefactorScore;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RefactorDiceGamePlayer implements Comparable<RefactorDiceGamePlayer> {
    final private int MAX_DICE_NUM = 3;// 플레이어수
    final private String name; //플레이어 이름 1 ,2
    final private List<RefactorDice> diceList = new ArrayList<>();
    final private RefactorScore gameScore;

    public RefactorDiceGamePlayer(String name) {
        this.name = name;
        int diceNumberSum = rollEveryDicesIfWeCan();
        gameScore = new RefactorScore(diceNumberSum);
    }

    public RefactorScore getGameScore() {
        return gameScore;
    }

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


    public String getName() {
        return name;
    }

    @Override
    public int compareTo(RefactorDiceGamePlayer otherPlayer) {
        final int otherPlayerTotalScore=otherPlayer.getGameScore().getTotalScore();
        final int currentPlayerTotalScore=this.getGameScore().getTotalScore();
        if (otherPlayerTotalScore<currentPlayerTotalScore){
            return 1;
        } else if(otherPlayerTotalScore>currentPlayerTotalScore){
            return -1;
        }
        return 0;
    }

    public RefactorDice getSelectedGameDice(int index) {
        if (diceList.size() > index) {
            return diceList.get(index);
        }
        return null;
    }

    @Override
    public String toString() {
        return "RefactorDiceGamePlayer{" +
                "name='" + name + '\'' +
                ", diceList=" + diceList +
                ", gameScore=" + gameScore +
                '}';
    }
}