package game.diceGame;

import game.diceGame.player.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GameManager {
    final private int PLAYER_NUM;
    final private List<Player> playerList = new ArrayList<>();
    final private Scanner scan = new Scanner(System.in);

    public GameManager() {
        System.out.println("게임시작!");
        System.out.println("플레이어 수를 입력해주세요(최소 2인)");
        this.PLAYER_NUM = scan.nextInt();

        if (PLAYER_NUM >= 2){
            for (int i = 0; i < PLAYER_NUM; i++) {
                playerList.add(new Player("플레이어" + (i + 1)));
                System.out.println(playerList.get(i));
            }
        }
        else {
            System.out.println("올바른 숫자를 입력해주세요!");
        }
    }

//    private int findTargetPlayerIndex (int currentPlayerIndex) {
//        // 상대편 찾기 (1:1 상황)
//        int targetPlayerIndex = 0;
//        if (currentPlayerIndex == 0) {
//            targetPlayerIndex = 1;
//        }
//        return targetPlayerIndex;
//    }

    private int findSpecialDiceNumber (int playerIndex) {
        final int ARRAY_BIAS = 1;
        final int SPECIAL_DICE_INDEX = 3 - ARRAY_BIAS;

        Dice currentPlayerSpecialDice =
                playerList.get(playerIndex).getSelectedGameDice(SPECIAL_DICE_INDEX);

        if (currentPlayerSpecialDice == null) { return 0; }

        return currentPlayerSpecialDice.getDiceNumber();
    }
    public void playGame() {
        final int STEAL = 1;
        final int BUFF = 3;
        final int DEATH = 4;
        final int STEAL_SCORE = 3;
        final int BUFF_SCORE = 2;
        final int DEATH_SCORE = -100;
        for (int i = 0; i < PLAYER_NUM; i++) {
            int currentPlayerSpecialDiceNumber = findSpecialDiceNumber(i);
            if (currentPlayerSpecialDiceNumber == 0) { continue; }
            // TODO: 확장성이 떨어지므로 개선 필요 -> 상대편 찾기 (1:1 상황)
//            int targetPlayerIndex = findTargetPlayerIndex(i);

//            GameScore PlayerScore =
//                    playerList.get(targetPlayerIndex).getGameScore();

            GameScore currentPlayerScore =
                    playerList.get(i).getGameScore();

            switch (currentPlayerSpecialDiceNumber) {
                case STEAL:
                    for (int j = 0; j < playerList.size(); j++){
                        playerList.get(j).getGameScore().
                                takeScore(playerList.get(j).getGameScore(), STEAL_SCORE);
                    }
                    currentPlayerScore.addScore(STEAL_SCORE * PLAYER_NUM);
                    break;
                    // 모든 플레이어 STEAL_SCORE 감소 후
                    // currentPlayer 점수 += STEAL_SCORE * PLAYER_NUM

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
        List<Integer> ResultScoreList = new ArrayList<>();
        for (Player player : playerList) {
            GameScore ResultScore = player.getGameScore();
            ResultScoreList.add(ResultScore.getTotalScore());
        }

        int[] rank = new int[ResultScoreList.size()];
        Arrays.fill(rank, 1);
        for (int i = 0; i < rank.length; i++){
            for (int j = 0; j < rank.length; j++){
                if (ResultScoreList.get(i) < ResultScoreList.get(j)){
                    rank[i]++;
                }
            }
        }
        for (int i = 0; i < rank.length; i++){
            if (ResultScoreList.get(i) > -100) {
                System.out.println("플레이어" + (i + 1) + ": " + rank[i] + "등");
            }
            else {
                System.out.println("플레이어" + (i + 1) + ": 패배");
            }
        }
    }
}