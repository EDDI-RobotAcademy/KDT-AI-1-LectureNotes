package homework.diceGame.game;

import java.util.ArrayList;
import java.util.List;

public class GameManager2 {
    int numOfPlayers = 3;
    List<Player2> playersList = new ArrayList<>();


    public GameManager2() {
        for(int i = 0; i < numOfPlayers; i++) {
            playersList.add(new Player2("플레이어" + (i + 1)));
            System.out.println(playersList.get(i));
        }
    }

    public List<Integer> findTargetPlayerIndex(int currentPlayerIndex) {
        List<Integer> targetPlayerIndexArray = new ArrayList<>();

        for(int i = 0; i < numOfPlayers; i++){
            if (i == currentPlayerIndex) { continue; }
            targetPlayerIndexArray.add(i);
        }
        return targetPlayerIndexArray;
    }

    public int findSpecialDiceNumber(int PlayerIndex){
        final int ARRAY_BIAS = 1;
        final int SPECIAL_DICE_INDEX = 3 - ARRAY_BIAS;

        Dice2 currentPlayerSpecialDice =
                playersList.get(PlayerIndex).getSpecialDice(SPECIAL_DICE_INDEX);

        if(currentPlayerSpecialDice == null){
            return 0;
        }
        int currentPlayerSpecialDiceNumber =
                currentPlayerSpecialDice.getDiceNumber(SPECIAL_DICE_INDEX);

        return currentPlayerSpecialDiceNumber;
    }

    public void playGame2(){
        final int STEAL = 1;
        final int BUFF = 3;
        final int DEATH = 4;

        final int STEAL_SCORE = 3;
        final int BUFF_SCORE = 2;
        final int DEATH_SCORE = -1;

        for(int i = 0; i < numOfPlayers; i++){
            int currentPlayerSpecialDiceNumber = findSpecialDiceNumber(i);
            if (currentPlayerSpecialDiceNumber == 0) { continue; }

            List<Integer> findTargetPlayerIndex = findTargetPlayerIndex(i); // 타겟인덱스의 리스트

            GameScore2 currentGameScore = playersList.get(i).getGamescore2();

            GameScore2[] targetGameScore = new GameScore2[(numOfPlayers-1)];
            for(int j = 0; j < (numOfPlayers-1); j++) {
                targetGameScore[j] = playersList.get(findTargetPlayerIndex.get(j)).getGamescore2();
            }

            switch (currentPlayerSpecialDiceNumber) {
                case STEAL:

                    for(int k = 0; k < (numOfPlayers-1); k++) {
                        targetGameScore[k].takeScore(currentGameScore, STEAL_SCORE);
                    }
                    break;

                case BUFF:
                    currentGameScore.addScore(BUFF_SCORE);
                    break;

                case DEATH:
                    currentGameScore.loseAll(DEATH_SCORE);
                    break;
            }
        }
    }

    public void printResult() {
        for (int i = 0; i < numOfPlayers; i++) {
            System.out.println(playersList.get(i));
        }
    }
    public void checkWinner() {

        List<GameScore2> playerScoreList = null;
        for (int i = 0; i < numOfPlayers; i++) {
            playerScoreList = new ArrayList<>();
            GameScore2 PlayersScore = playersList.get(i).getGamescore2();
            playerScoreList.add(PlayersScore);
        }

//        GameScore2 firstPlayerScore = playersList.get(0).getGamescore2();
//        GameScore2 secondPlayerScore = playersList.get(1).getGamescore2();
//
//        final int firstPlayerScoreTotalScore = firstPlayerScore.getGameScore();
//        final int secondPlayerScoreTotalScore = secondPlayerScore.getGameScore();
//
//        if (firstPlayerScoreTotalScore > secondPlayerScoreTotalScore) {
//            System.out.println("승자: " + playersList.get(0).getName());
//            return;
//        }
//        if (firstPlayerScoreTotalScore < secondPlayerScoreTotalScore) {
//            System.out.println("승자: " + playersList.get(1).getName());
//            return;
//        }

    }

}
