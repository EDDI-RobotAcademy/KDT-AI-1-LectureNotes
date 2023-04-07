package homework.sixth.diceProb3;

import utility.CustomRandom;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameManager {
    Scanner scanner =new Scanner(System.in);

    final private int PLAYER_NUM = scanner.nextByte();
    final private List<Player> playerList = new ArrayList<>();

    public GameManager() {
        for (int i = 0; i < PLAYER_NUM; i++) {
            playerList.add(new Player("플레이어" + (i + 1)));
            System.out.println(playerList.get(i));
        }
    }

    private int findTargetPlayerIndex (int currentPlayerIndex) {

        // 상대편 찾기 (랜덤 상대 찾기 상황)
        final int HUND=100;//100
        int targetPlayerIndex = 0;
        for(int i=0;i<HUND;i++){
            targetPlayerIndex=CustomRandom.generateNumber(PLAYER_NUM);//플레이어의 숫자는 스캐너로 플레이할때 지정함

            if (targetPlayerIndex!=currentPlayerIndex){
                break;
            }
        }
        return targetPlayerIndex;

//        if (currentPlayerIndex == 0) {
//            targetPlayerIndex=1;
//        }


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

            // TODO: 확장성이 떨어지므로 개선 필요 -> 상대편 찾기 (1:1 상황)
            int targetPlayerIndex = findTargetPlayerIndex(i);

            GameScore targetPlayerScore =
                    playerList.get(targetPlayerIndex).getGameScore();

            GameScore currentPlayerScore =
                    playerList.get(i).getGameScore();

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
            System.out.println(playerList.get(i));
        }
    }

    public void checkWinner() {


        List<GameScore> checkScore = new ArrayList<>();
        for (int i = 0; i < PLAYER_NUM; i++) { //스캐너로 플레이 할 사람의 숫자 지정함

            checkScore.add(playerList.get(i).getGameScore()); //리스트에 플레이어들의 점수를 넣었습니다.

        }
        int max = -100;
        for (int i = 1; i < checkScore.size(); i++) { //체크 스코어라는 리스트의 최댓값을 구해서 최댓값의 인덱스를 우승자로 만드려고 합니다.
            if (checkScore.get(i).getTotalScore() > max) {
                max = checkScore.get(i).getTotalScore();
            }
        }
        int winnerIndex = checkScore.indexOf(max);
        System.out.println("승자는" + playerList.get(winnerIndex).getName());


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
        System.out.printf("무승부");


    }   }
