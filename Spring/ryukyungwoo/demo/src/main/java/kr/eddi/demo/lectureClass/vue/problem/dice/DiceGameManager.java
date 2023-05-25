package kr.eddi.demo.lectureClass.vue.problem.dice;

import kr.eddi.demo.lectureClass.vue.problem.player.Player;
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
    public DiceGameManager(int playerNum, int diceMaxNumber) {
        playerList = new ArrayList<>();

        final int CONDITION_DICE_IDX = 0;

        for (int i = 0; i < playerNum; i++) {
            final Player player = new Player(diceMaxNumber, CONDITION_DICE_IDX, (i + 1));
            playerList.add(player);
        }
    }

    public String checkWinIfSumEven (int playerDiceSumResult) {
        final int DECISION_WIN = 2;
        final int EVEN = 0;

        if (playerDiceSumResult % DECISION_WIN == EVEN) {
            return "Win!";
        }

        return "Lose!";
    }

    public String checkWinner () {
        final Player firstPlayer = playerList.get(0);
        final int firstPlayerScore = firstPlayer.getDiceSum();

        final Player secondPlayer = playerList.get(1);
        final int secondPlayerScore = secondPlayer.getDiceSum();

        if (firstPlayerScore > secondPlayerScore) {
            return "winner: " + firstPlayer.getName();
        }
        if (firstPlayerScore < secondPlayerScore) {
            return "winner: " + secondPlayer.getName();
        }

        return "draw";
    }

    public int calculatePlayerDiceSum() {
        final List<Dice> currentPlayerDiceList = playerList.get(0).getDiceList();

        int tmpSum = 0;
        for (int i = 0; i < currentPlayerDiceList.size(); i++) {
            tmpSum += currentPlayerDiceList.get(i).getDiceNumber();
        }

        return tmpSum;
    }

    public void applyCondition () {
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

            final int conditionDiceNumber = currentPlayerDice.getDiceNumber();

            switch (conditionDiceNumber) {
                case STEAL:
                    final int targetPlayerIdx = findTargetPlayerIdx(i);
                    final Player targetPlayer = playerList.get(targetPlayerIdx);
                    final int targetDiceSum = targetPlayer.getDiceSum();
                    currentPlayer.setDiceSum(currentPlayerDiceSum + STEAL_SCORE);
                    targetPlayer.setDiceSum(targetDiceSum - STEAL_SCORE);
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

    public int findTargetPlayerIdx (int currentPlayerIdx) {
        if (currentPlayerIdx == 0) {
            return 1;
        }

        return 0;
    }
}
