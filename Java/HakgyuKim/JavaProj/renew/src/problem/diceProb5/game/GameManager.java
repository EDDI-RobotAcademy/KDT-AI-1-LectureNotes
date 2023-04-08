package problem.diceProb5.game;

import problem.diceProb5.player.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameManager {
    final private int PLAYER_NUM = 5;
    final private List<Player> playerList = new ArrayList<>();

    public GameManager() {
        for (int i = 0; i < PLAYER_NUM; i++) {
            playerList.add(new Player("플레이어" + (i + 1)));
            System.out.println(playerList.get(i));
        }
    }



    private int findTargetPlayerIndex (int currentPlayerIndex) {
        // 다음 플레이어 찾기 (마지막 순서면 1번 플레이어 찾기)
        int targetPlayerIndex = currentPlayerIndex + 1;
        if (currentPlayerIndex == PLAYER_NUM - 1) {
            targetPlayerIndex = 0;
        }
        return targetPlayerIndex;
    }



    private int findCurrentPlayerIndex (int currentPlayerIndex) {
        return currentPlayerIndex;
    }

    private int findSpecialDiceNumber (int playerIndex) {
        final int ARRAY_BIAS = 1;
        final int SPECIAL_DICE_INDEX = 3 - ARRAY_BIAS;

        Dice currentPlayerSpecialDice =
                playerList.get(playerIndex).getSelectedGameDice(SPECIAL_DICE_INDEX);

        if (currentPlayerSpecialDice == null) { return 0; }

        int currentPlayerSpecialDiceNumber =
                currentPlayerSpecialDice.getDiceNumber();

        return currentPlayerSpecialDiceNumber;
    }

    public void playGame() {
        final int STEAL = 1;
        final int BUFF = 3;
        final int DEATH = 4;

        final int STEAL_SCORE = 3;
        final int BUFF_SCORE = 2;
        final int DEATH_SCORE = 0;

        for (int i = 0; i < PLAYER_NUM; i++) {
            int currentPlayerSpecialDiceNumber = findSpecialDiceNumber(i);

            if (currentPlayerSpecialDiceNumber == 0) { continue; }

            int currentPlayerIndex = findCurrentPlayerIndex(i);

            /*
            int targetPlayerIndex = findTargetPlayerIndex(i);

            GameScore targetPlayerScore =
                    playerList.get(targetPlayerIndex).getGameScore();
             */

            GameScore currentPlayerScore =
                    playerList.get(i).getGameScore();

            switch (currentPlayerSpecialDiceNumber) {
                case STEAL:
                    /*
                    targetPlayerScore.takeScore(currentPlayerScore, STEAL_SCORE);
                     */
                    for (int j = 0; j < PLAYER_NUM; j++) {
                        if (j == currentPlayerIndex) {continue;}
                        if (playerList.get(j).getGameScore().getTotalScore() < 2) {continue;}
                        playerList.get(j).getGameScore().takeScore(currentPlayerScore, STEAL_SCORE);
                    }
                    break;

                case BUFF:
                    currentPlayerScore.addScore(BUFF_SCORE);
                    break;

                case DEATH:
                    currentPlayerScore.loseAll(DEATH_SCORE);
                    break;
            }
        }
    }

    public void attack() {
        for (int i = 0; i < PLAYER_NUM; i++) {
            int currentPlayerIndex = findCurrentPlayerIndex(i);
            int targetPlayerIndex = findTargetPlayerIndex(i);

            int currentPlayerHealth = playerList.get(currentPlayerIndex).getHealth();
            int targetPlayerHealth = playerList.get(targetPlayerIndex).getHealth() -
                    playerList.get(currentPlayerIndex).getGameScore().getTotalScore();

        }
    }

    public void printResult() {
        for (int i = 0; i < PLAYER_NUM; i++) {
            System.out.println(playerList.get(i));
        }
    }

/*
    public void checkWinner() {
        List<Integer> playerTotalScoreList = new ArrayList<>();
        for (int i = 0; i < PLAYER_NUM; i++) {
            playerTotalScoreList.add(playerList.get(i).getGameScore().getTotalScore());
        }
        int winnerScore = Collections.max(playerTotalScoreList);
        for (int j = 0; j < PLAYER_NUM; j++) {
            if (playerList.get(j).getGameScore().getTotalScore() == winnerScore) {
                System.out.println("승자는: " + playerList.get(j).getName());
            }
        }
    }
 */


    /*
    public void
     */
}