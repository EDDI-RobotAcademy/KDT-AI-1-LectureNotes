package com.example.demo.lectureClass.homework.basic1.answer.problem2.dice;

import com.example.demo.lectureClass.homework.basic1.answer.problem2.player.Player;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class DiceGameManager {

    private List<Player> playerList;

    /* 싱글 플레이 */
    public DiceGameManager(int diceMaxNumber) {
        playerList = new ArrayList<>();

        playerList.add(new Player(diceMaxNumber));
    }

    /* 멀티 플레이 */
    public DiceGameManager (int playerNum, int diceNum) {
        playerList = new ArrayList<>();

        final int CONDITION_DICE_IDX = 0;

        for (int i = 0; i < playerNum; i++) {
            final Player player = new Player(diceNum, CONDITION_DICE_IDX, i + 1);
            playerList.add(player);
        }
    }



    public String checkWinIfSumEven (int currentPlayerDiceSum) {
        final int DECISION_WIN = 2;
        final int EVEN = 0;

        if (currentPlayerDiceSum % DECISION_WIN == EVEN) {
            return "승리!";
        }
        return "패배!";
    }

    public int calculatePlayerDiceSum() {
        final List<Dice> currentPlayerDiceList = playerList.get(0).getDiceList();

        int tmpSum = 0;
        for (int i = 0; i < currentPlayerDiceList.size(); i++) {
            tmpSum += currentPlayerDiceList.get(i).getDiceNumber();
        }
        return tmpSum;
    }

    public void applyCondition() {
        final int CONDITION_DICE_IDX = 2;

        final int STEAL = 1;
        final int BUFF = 3;
        final int DEATH = 4;

        final int STEAL_SCORE = 3;
        final int BUFF_SCORE = 2;
        final int DEATH_SCORE = -777;

        for (int i = 0; i < playerList.size(); i++) {
            final Player currentPlayer = playerList.get(i);
            final int currentPlayerDiceSum = currentPlayer.getDiceSum();

            final Dice currentPlayerDice = currentPlayer.getDice(CONDITION_DICE_IDX);

            if (currentPlayerDice == null) {
                continue;
            }
            final int conditionDiceNumber = currentPlayer.getDice(CONDITION_DICE_IDX).getDiceNumber();

            switch (conditionDiceNumber) {
                case STEAL:
                    final int targetPlayerIdx = finaTargetPlayerIdx(i);
                    final Player targetPlayer = playerList.get(targetPlayerIdx);
                    final int targetPlayerDiceSum = targetPlayer.getDiceSum();
                    currentPlayer.setDiceSum(currentPlayerDiceSum + STEAL_SCORE);
                    targetPlayer.setDiceSum(targetPlayerDiceSum - STEAL_SCORE);
                    break;

                case BUFF:
                    currentPlayer.setDiceSum(currentPlayerDiceSum + BUFF_SCORE);
                    break;

                case DEATH:
                    currentPlayer.setDiceSum(DEATH_SCORE);
                    break;
            }
        }
    }

    public int finaTargetPlayerIdx (int currentPlayerIdx) {
        if (currentPlayerIdx == 0) {
            return 1;
        }

        return 0;
    }

    public String checkWinner () {
        final Player firstPlayer = playerList.get(0);
        final int firstPlayerScore = playerList.get(0).getDiceSum();

        final Player secondPlayer = playerList.get(1);
        final int secondPlayerScore = playerList.get(1).getDiceSum();

        if (firstPlayerScore > secondPlayerScore) {
            return "승자는: " + firstPlayer.getName();
        }
        if (firstPlayerScore < secondPlayerScore) {
            return "승자는: " + secondPlayer.getName();
        }

        return "무승부!";
    }
}
