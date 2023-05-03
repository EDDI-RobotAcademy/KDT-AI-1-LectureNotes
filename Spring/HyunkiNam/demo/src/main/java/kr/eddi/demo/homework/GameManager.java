package kr.eddi.demo.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GameManager {
    final private int PLAYER_NUM = 2;
    final private List<Player> playerList = new ArrayList<>();

    public GameManager() {
        for (int i = 0; i < PLAYER_NUM; i++) {
            playerList.add(new Player("플레이어" + (i + 1)));
            System.out.println(playerList.get(i));
        }
    }

    private List<Integer> findTargetPlayerList (int currentPlayerIndex) {
        List<Integer> targetPlayerList = new ArrayList<>();

        for(int i=0; i<PLAYER_NUM; i++){
            if(i == currentPlayerIndex){
                continue;
            }
            targetPlayerList.add(i);
        }
        return targetPlayerList;
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
        final int DEATH_SCORE = -1;

        for (int i = 0; i < PLAYER_NUM; i++) {
            int currentPlayerSpecialDiceNumber = findSpecialDiceNumber(i);

            if (currentPlayerSpecialDiceNumber == 0) { continue; }

            List<Integer> targetPlayerList = findTargetPlayerList(i);

            GameScore currentPlayerScore =
                    playerList.get(i).getGameScore();

            switch (currentPlayerSpecialDiceNumber) {
                case STEAL:
                    currentPlayerScore.takeScore(playerList, STEAL_SCORE, targetPlayerList);
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

    public List<String> findWinnerPlayer(){
        List<String> winnerPlayerList = new ArrayList<>();

        Collections.sort(playerList, new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                return o1.getGameScore().getTotalScore() - o2.getGameScore().getTotalScore();
            }
        });

        for(int i=0; i<PLAYER_NUM; i++){
            if(playerList.get(PLAYER_NUM-1).getGameScore().getTotalScore() == playerList.get(i).getGameScore().getTotalScore()){
                winnerPlayerList.add(playerList.get(i).getName());
            }
        }

        return winnerPlayerList;
    }

    public List<Player> printPlayerList(){

        return playerList;
        //return findWinnerPlayer();
    }
    public List<String> checking(){
        return findWinnerPlayer();
    }
}