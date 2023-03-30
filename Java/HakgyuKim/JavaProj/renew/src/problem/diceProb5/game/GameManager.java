package problem.diceProb5.game;

import problem.diceProb5.player.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameManager {
    final private int PLAYER_NUM = 3;
    final private List<Player> playerList = new ArrayList<>();

    public GameManager() {
        for (int i = 0; i < PLAYER_NUM; i++) {
            playerList.add(new Player("플레이어" + (i + 1)));
            System.out.println(playerList.get(i));
        }
    }

    private int findTargetPlayerIndex (int currentPlayerIndex) {
        // 상대편 찾기 (1:1 상황)
        int targetPlayerIndex =0;
        for (int i = 0; i < PLAYER_NUM; i++) {
            currentPlayerIndex = i;
            targetPlayerIndex = i+1;
            if (currentPlayerIndex == PLAYER_NUM - 1) {
                targetPlayerIndex = 0;
            }
        }
        return targetPlayerIndex;
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
        final int DEATH_SCORE = -10;

        for (int i = 0; i < PLAYER_NUM; i++) {
            int currentPlayerSpecialDiceNumber = findSpecialDiceNumber(i);

            if (currentPlayerSpecialDiceNumber == 0) { continue; }

            // TODO: 확장성이 떨어지므로 개선 필요 -> 상대편 찾기 (1:1 상황)
            int targetPlayerIndex = findTargetPlayerIndex(i);

            GameScore targetPlayerScore =
                    playerList.get(targetPlayerIndex).getGameScore();

            GameScore currentPlayerScore =
                    playerList.get(i).getGameScore();

            switch (currentPlayerSpecialDiceNumber) {
                case STEAL:
                    targetPlayerScore.takeScore(currentPlayerScore, STEAL_SCORE);
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

    public void printResult() {
        for (int i = 0; i < PLAYER_NUM; i++) {
            System.out.println(playerList.get(i));
        }
    }

    public void checkWinner() {
        // TODO: 확장성 문제가 존재함 추후 사용자 숫자 증대시 리팩토링 필요
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
}