package diceGame.game;

import diceGame.player.RefactorPlayer;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    final private int PLAYER_NUM = 2;
    final private List<RefactorPlayer> refactorPlayerList = new ArrayList<>();

    public GameManager() {
        for (int i = 0; i < PLAYER_NUM; i++) {
            refactorPlayerList.add(new RefactorPlayer("플레이어" + (i + 1)));
            System.out.println(refactorPlayerList.get(i));
        }
    }

    private int findTargetPlayerIndex (int currentPlayerIndex) {
        // 상대편 찾기 (1:1 상황)
        int targetPlayerIndex = 0;

        if (currentPlayerIndex == 0) {
            targetPlayerIndex = 1;
        }

        return targetPlayerIndex;
    }

    private int findSpecialDiceNumber (int playerIndex) {
        final int ARRAY_BIAS = 1;
        final int SPECIAL_DICE_INDEX = 3 - ARRAY_BIAS;

        Dice currentPlayerSpecialDice =
                refactorPlayerList.get(playerIndex).getSelectedGameDice(SPECIAL_DICE_INDEX);

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
        final int DEATH_SCORE = -1;

        for (int i = 0; i < PLAYER_NUM; i++) {
            int currentPlayerSpecialDiceNumber = findSpecialDiceNumber(i);

            if (currentPlayerSpecialDiceNumber == 0) { continue; }

            // TODO: 확장성이 떨어지므로 개선 필요 -> 상대편 찾기 (1:1 상황)
            int targetPlayerIndex = findTargetPlayerIndex(i);

            GameScore targetPlayerScore =
                    refactorPlayerList.get(targetPlayerIndex).getGameScore();

            GameScore currentPlayerScore =
                    refactorPlayerList.get(i).getGameScore();

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
            System.out.println(refactorPlayerList.get(i));
        }
    }

    public void checkWinner() {
        // TODO: 확장성 문제가 존재함 추후 사용자 숫자 증대시 리팩토링 필요
        GameScore firstPlayerScore = refactorPlayerList.get(0).getGameScore();
        GameScore secondPlayerScore = refactorPlayerList.get(1).getGameScore();

        final int firstPlayerScoreTotalScore = firstPlayerScore.getTotalScore();
        final int secondPlayerScoreTotalScore = secondPlayerScore.getTotalScore();

        if (firstPlayerScoreTotalScore > secondPlayerScoreTotalScore) {
            System.out.println("승자: " + refactorPlayerList.get(0).getName());
            return;
        }
        if (firstPlayerScoreTotalScore < secondPlayerScoreTotalScore) {
            System.out.println("승자: " + refactorPlayerList.get(1).getName());
            return;
        }

        System.out.println("무승부");
    }
}
