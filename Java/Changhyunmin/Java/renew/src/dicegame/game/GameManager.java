package dicegame.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import dicegame.game.GameScore;

public class GameManager {
    final private int PLAYER_NUM = new Scanner(System.in).nextInt();
    ;
    final private List<Player> playerList = new ArrayList<>();

    public GameManager() {

        for (int i = 0; i < PLAYER_NUM; i++) {

            playerList.add(new Player("플레이어" + (i + 1)));
            System.out.println(playerList.get(i));
        }
    }
    private int findTargetPlayerIndex (int currentPlayerIndex) {
        // 상대편 찾기 (1:1 상황)

        int targetPlayerIndex = 0;
        if (currentPlayerIndex == 0) {
            targetPlayerIndex = PLAYER_NUM;
        }
        return targetPlayerIndex;
    }
    private int findSpecialDiceNumber (int playerIndex) {
        final int ARRAY_BIAS = 1;
        final int SPECIAL_DICE_INDEX = 3 - ARRAY_BIAS;

        Dice currentPlayerSpecialDice = playerList.get(playerIndex).getSelectedGameDice(SPECIAL_DICE_INDEX);

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
            playerList.get(targetPlayerIndex).getGameScore();

            GameScore currentPlayerScore =
            playerList.get(i).getGameScore();

            switch (currentPlayerSpecialDiceNumber) {
                case STEAL:
                    for (int ii = 0; ii < playerList.size(); ii++){
                      playerList.get(ii).getGameScore();
                        targetPlayerScore.takeScore
                                (playerList.get(ii).getGameScore(), STEAL_SCORE);
                        currentPlayerScore.addScore(STEAL_SCORE * PLAYER_NUM);
                    }
                    //targetPlayerScore.takeScore(currentPlayerScore, STEAL_SCORE);
                    break;
                case BUFF:
                    currentPlayerScore.addScore(BUFF_SCORE * PLAYER_NUM);
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
        List<Integer> ResultScoreList = new ArrayList<>();
        for (int i = 0; i < playerList.size(); i++) {
        GameScore ResultScore = playerList.get(i).getGameScore();
        ResultScoreList.add(ResultScore.getTotalScore());
        }
        int[] rank = new int[ResultScoreList.size()];



    }
}
