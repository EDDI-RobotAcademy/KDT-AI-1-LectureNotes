package homework6.game;

import java.util.ArrayList;
import java.util.List;

public class Score {
    final private List<List<Dice>> scoreBoard;
    final private List<Integer> totalScoreBoard;

    public Score(int playerNumber) {
        scoreBoard = new ArrayList<>();
        totalScoreBoard = new ArrayList<>();

        for (int i = 0; i < playerNumber; i++) {
            scoreBoard.add(new ArrayList<Dice>());
            totalScoreBoard.add(0);
        }
    }

    public int getTotalScore(int playerIndex) {
        return totalScoreBoard.get(playerIndex);
    }

    public String getScoreBoard(int playerIndex) {
        return this.scoreBoard.get(playerIndex).toString();
    }

    public void record(Dice dice, int playerIndex) {
        scoreBoard.get(playerIndex).add(dice);
        int totalScore = totalScoreBoard.get(playerIndex);
        totalScoreBoard.set(playerIndex, dice.getDiceNumber() + totalScore);
    }

    public boolean isQualify(int playerIndex) {
        final int TARGET_DICE = 0;
        final int QULAIFY_NUMBER = 2;
        final int EVEN = 0;
        
        if (scoreBoard.get(playerIndex).get(TARGET_DICE).getDiceNumber() % QULAIFY_NUMBER == EVEN) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Score{" +
                "scoreBoard=" + scoreBoard +
                ", totalScoreBoard=" + totalScoreBoard +
                '}';
    }

    public void specialRoundEvent(int playerIndex) {

        final int STEAL = 1;
        final int STEAL_POINT = 3;
        final int ADD = 3;
        final int ADD_POINT = 2;
        final int DEATH = 4;
        final int DEATH_POINT = -1;

        final int specialDiceNumber = scoreBoard.get(playerIndex).get(scoreBoard.get(playerIndex).size() - 1).getDiceNumber();

        int counterPlayerIndex = playerIndex == 0 ? 1 : 0;

        switch (specialDiceNumber) {

            case STEAL -> {
                totalScoreBoard.set(playerIndex, totalScoreBoard.get(playerIndex) + STEAL_POINT);
                totalScoreBoard.set(counterPlayerIndex, totalScoreBoard.get(counterPlayerIndex) - STEAL_POINT);
            }
            case ADD -> totalScoreBoard.set(playerIndex, totalScoreBoard.get((playerIndex)) + ADD_POINT);
            case DEATH -> totalScoreBoard.set(playerIndex, DEATH_POINT);
        }
    }
}
