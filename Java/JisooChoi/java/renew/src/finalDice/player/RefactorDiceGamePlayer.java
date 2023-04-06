package finalDice.player;

import finalDice.dice.RefactorDice;
import finalDice.score.RefactorScore;

import java.util.ArrayList;
import java.util.List;

public class RefactorDiceGamePlayer implements Comparable<RefactorDiceGamePlayer>{
    final private int MAX_DICE_NUM = 3;
    final private String name;
    final private List<RefactorDice> gameDiceList = new ArrayList<>();
    final private RefactorScore gameScore;

    public RefactorDiceGamePlayer(String name) {
        this.name = name;

        int diceNumberSum = rollDice();
        gameScore = new RefactorScore(diceNumberSum);
    }

    private int rollDice() {
        final int FIRST_DICE_INFO = 0;
        final int DECISION_EVEN = 2;
        final int ODD = 1;

        int diceNumberSum = 0;

        for (int i = 0; i < MAX_DICE_NUM; i++) {
            // ▲ 2
            gameDiceList.add(new RefactorDice());

            diceNumberSum += gameDiceList.get(i).getDiceNumber();

            if(gameDiceList.get(i).getDiceNumber() % DECISION_EVEN == ODD){
                break;
            }
        }

        return diceNumberSum;
    }

    public RefactorDice getSelectedGameDice(int index) {
        // 유효성 검사 필요
        if(gameDiceList.size() > index){
            return gameDiceList.get(index);
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
                ", gameDiceList=" + gameDiceList +
                ", gameScore=" + gameScore +
                '}';
    }

    @Override
    public int compareTo(RefactorDiceGamePlayer otherPlayer){
        final int otherPlayersTotalScore = otherPlayer.getGameScore().getTotalScore();
        final int currentPlayerTotalScore = this.getGameScore().getTotalScore();

        if(otherPlayersTotalScore < currentPlayerTotalScore){
            return 1;
        } else if (otherPlayersTotalScore > currentPlayerTotalScore) {
            return -1;
        }
        return 0;
    }
}