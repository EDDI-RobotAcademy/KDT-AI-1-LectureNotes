package finalDice.manager;

import diceGame.game.Dice;
import diceGame.game.GameScore;
import diceGame.player.RefactorPlayer;
import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class FinalDiceGameManager {
    final private int PLAYER_NUM = 3;
    final private List<RefactorPlayer> playerList = new ArrayList<>();

    public FinalDiceGameManager() {
        for (int i = 0; i < PLAYER_NUM; i++) {
            playerList.add(new RefactorPlayer("플레이어" + (i + 1)));
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

    public void checkWinner() {

        Collections.sort(playerList, Collections.reverseOrder());
        System.out.println(playerList);
        // TODO: 확장성 문제가 존재함 추후 사용자 숫자 증대시 리팩토링 필요
//        GameScore firstPlayerScore = playerList.get(0).getGameScore();
//        GameScore secondPlayerScore = playerList.get(1).getGameScore();
//
//        final int firstPlayerScoreTotalScore = firstPlayerScore.getTotalScore();
//        final int secondPlayerScoreTotalScore = secondPlayerScore.getTotalScore();
//
//        if (firstPlayerScoreTotalScore > secondPlayerScoreTotalScore) {
//            System.out.println("승자: " + playerList.get(0).getName());
//            return;
//        }
//        if (firstPlayerScoreTotalScore < secondPlayerScoreTotalScore) {
//            System.out.println("승자: " + playerList.get(1).getName());
//            return;
//        }
//
//        System.out.println("무승부");
    }
}
