package com.example.demo.lectureClass.vue.homework.dicegame.game;

import com.example.demo.lectureClass.vue.homework.dicegame.player.Player;
import com.example.demo.lectureClass.untility.random.CustomRandom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameManager {
    final private int PLAYER_NUM = 2;
    final private List<Player> playerList = new ArrayList<>();

    public GameManager() {
        for (int i = 0; i < PLAYER_NUM; i++) {
            playerList.add(new Player("player" + (i + 1)));
            System.out.println(playerList.get(i));
        }
    }

    private int findTargetPlayerIndex (int currentPlayerIdx) {
        int targetPlayerIdx = 0;

        do {
            targetPlayerIdx = CustomRandom.generateNumber(PLAYER_NUM - 1);
        } while (currentPlayerIdx == targetPlayerIdx);

        return targetPlayerIdx;
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
        for (int currentPlayerIdx = 0; currentPlayerIdx < PLAYER_NUM; currentPlayerIdx++) {
            final int currentPlayerSpecialDiceNumber = findSpecialDiceNumber(currentPlayerIdx);

            if (currentPlayerSpecialDiceNumber == 0) { continue; }

            final GameScore currentPlayerScore =
                    playerList.get(currentPlayerIdx).getGameScore();

            applyAbilityOfSpecialDice(
                    currentPlayerIdx,
                    currentPlayerSpecialDiceNumber,
                    currentPlayerScore);
        }
    }

    private void applyAbilityOfSpecialDice(
            int currentPlayerIdx,
            int currentPlayerSpecialDiceNumber,
            GameScore currentPlayerScore
    ) {
        final int STEAL = 1;
        final int BUFF = 3;
        final int DEATH = 4;

        final int STEAL_SCORE = 3;
        final int BUFF_SCORE = 2;
        final int DEATH_SCORE = -1;

        switch (currentPlayerSpecialDiceNumber) {
            case STEAL:
                final int targetPlayerIndex = findTargetPlayerIndex(currentPlayerIdx);
                final GameScore targetPlayerScore =
                        playerList.get(targetPlayerIndex).getGameScore();
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

    public void printResult() {
        for (int i = 0; i < PLAYER_NUM; i++) {
            System.out.println(playerList.get(i));
        }
    }
    public String checkWinner() {

        final int WINNER_IDX = 0;
        final int SECOND_IDX = 1;

        final int DRAW = 0;

        final String winnerName;
        final String draw;

        Collections.sort(playerList, Collections.reverseOrder());
        Player winner = playerList.get(WINNER_IDX);

        // 무승부
        Player second = playerList.get(SECOND_IDX);

        if (winner.compareTo(second) == DRAW) {
            draw = "draw";
            return draw;
        }

        winnerName = winner.getName();
        return winnerName;
    }

    @Override
    public String toString() {
        return "GameManager{" +
                "playerList=" + playerList +
                '}';
    }
}
