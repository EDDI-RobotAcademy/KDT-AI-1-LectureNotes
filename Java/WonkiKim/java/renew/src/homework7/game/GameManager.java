package homework7.game;

import homework7.game.player.Player;
import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class GameManager {
    final private int PLAYER_NUM = 10;
    final private List<Player> playerList = new ArrayList<>();
    final private TreeSet<Player> ranking = new TreeSet<>();

    public GameManager() {
        for (int i = 0; i < PLAYER_NUM; i++) {
            playerList.add(new Player("플레이어" + (i + 1)));
            System.out.println(playerList.get(i));
        }
    }

    private int randomTargetPlayerIndex(int currentPlayerIndex) {
        // 상대편 찾기 (1:1 상황)
        int targetPlayerIndex = currentPlayerIndex;

        while (targetPlayerIndex == currentPlayerIndex) {
            targetPlayerIndex = CustomRandom.generateNumber(PLAYER_NUM - 1);
        }

        return targetPlayerIndex;
    }

    private int findSpecialDiceNumber(int playerIndex) {
        final int ARRAY_BIAS = 1;
        final int SPECIAL_DICE_INDEX = 3 - ARRAY_BIAS;

        Dice currentPlayerSpecialDice =
                playerList.get(playerIndex).getSelectedGameDice(SPECIAL_DICE_INDEX);

        if (currentPlayerSpecialDice == null) {
            return 0;
        }

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
        final int DEATH_SCORE = -1;

        for (int i = 0; i < PLAYER_NUM; i++) {
            int currentPlayerSpecialDiceNumber = findSpecialDiceNumber(i);

            if (currentPlayerSpecialDiceNumber == 0) {
                continue;
            }

            // randomTarget으로 해결.
            int targetPlayerIndex = randomTargetPlayerIndex(i);

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
        Collections.sort(playerList);
        for (int i = 0; i < PLAYER_NUM; i++) {
            System.out.println(playerList.get(i));
        }
    }

    public void checkWinner() {
        // TODO: 두명의 플레이어의 3번재 주사위가 4일경우, -1 또 다른 플레이어의 1주사위로 인한 -3 발생으로 4주사위(무조건 패배) 제대로 작동 안함,
        int tie = 1;
        for (int i = 0; i < PLAYER_NUM; i++) {
            // 동점자 처리를 위해 i>0일때 바로 위 플레이어와 비교하여 동점자 처리
            // 단, 동점자가 3명 이상일 경우는 제대로 작동 안함. -> 변수 tie 도입으로 해결
            final int playerTotalScore = playerList.get(i).getGameScore().getTotalScore();

            if ((i > 0) && playerList.get(i - 1).getGameScore().getTotalScore() == playerTotalScore) {
                System.out.println(tie + "등: " + playerList.get(i).getName() +
                        ", TotalScore: " + playerTotalScore);
            } else {
                System.out.println((i + 1) + "등: " + playerList.get(i).getName() +
                        ", TotalScore: " + playerTotalScore);
                tie = i + 1;
            }
        }
    }
}
