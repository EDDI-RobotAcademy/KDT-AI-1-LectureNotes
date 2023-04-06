package diceProblem.manager;

import diceProblem.dice.RefactorDice;
import diceProblem.player.RefactorDiceGamePlayer;
import diceProblem.score.RefactorScore;
import utility.CustomRandom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FinalDiceGameManager {
    final private int PLAYER_NUM = 3;
    final private List<RefactorDiceGamePlayer> playerList = new ArrayList<>();

    public FinalDiceGameManager() {
        for (int i = 0; i < PLAYER_NUM; i++) {
            /*RefactorDiceGamePlayer playerList = new RefactorDiceGamePlayer("플레이어" + (i + 1));*/
            playerList.add(new RefactorDiceGamePlayer("플레이어" + (i + 1)));
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

        RefactorDice currentPlayerSpecialDice =
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

            final RefactorScore currentPlayerScore =
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
            RefactorScore currentPlayerScore
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
                final RefactorScore targetPlayerScore =
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
    public void checkWinner() {

        final int WINNER_IDX = 0;
        final int SECOND_IDX = 1;

        final int DRAW = 0;
        // RefactorPlayer가 Comparable<RefactorPlayer>를 가지고 있어야 하는데
        // Comparable<RefactorPlayer>가 없는데 왜 자꾸 sort 하려고 하냐면서 화내는 모습
        // class diceGame.player.RefactorPlayer cannot be cast to class java.lang.Comparable
        // (diceGame.player.RefactorPlayer is in unnamed module of loader 'app';
        Collections.sort(playerList, Collections.reverseOrder());
        RefactorDiceGamePlayer winner = playerList.get(WINNER_IDX);

        // 무승부
        RefactorDiceGamePlayer second = playerList.get(SECOND_IDX);

        if (winner.compareTo(second) == DRAW) {
            System.out.println("무승부!");
            return;
        }

        System.out.println("승리: " + winner.getName());
        System.out.println("전적 상황: " + playerList);
    }


}