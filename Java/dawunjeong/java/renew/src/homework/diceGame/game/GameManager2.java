package homework.diceGame.game;

import java.util.*;

public class GameManager2 {
    int numOfPlayers;
    List<Player2> playersList = new ArrayList<>();

    public GameManager2() {
        Scanner scan = new Scanner(System.in);
        System.out.println("플레이어의 수를 입력하세요.");
        numOfPlayers = scan.nextInt();
        for (int i = 0; i < numOfPlayers; i++) {
            playersList.add(new Player2("플레이어" + (i + 1)));
            System.out.println(playersList.get(i));
        }
    }

    public List<Integer> findTargetPlayerIndex(int currentPlayerIndex) {
        List<Integer> targetPlayerIndexArray = new ArrayList<>();

        for (int i = 0; i < numOfPlayers; i++) {
            if (i == currentPlayerIndex) {
                continue;
            }
            targetPlayerIndexArray.add(i);
        }
        return targetPlayerIndexArray;
    }

    public int findSpecialDiceNumber(int PlayerIndex) {
        final int ARRAY_BIAS = 1;
        final int SPECIAL_DICE_INDEX = 3 - ARRAY_BIAS;

        Dice2 currentPlayerSpecialDice =
                playersList.get(PlayerIndex).getSpecialDice(SPECIAL_DICE_INDEX);

        if (currentPlayerSpecialDice == null) {
            return 0;
        }
        int currentPlayerSpecialDiceNumber =
                currentPlayerSpecialDice.getDiceNumber(SPECIAL_DICE_INDEX);

        return currentPlayerSpecialDiceNumber;
    }

    public void playGame2() {
        final int STEAL = 1;
        final int BUFF = 3;
        final int DEATH = 4;

        final int STEAL_SCORE = 3;
        final int BUFF_SCORE = 2;
        final int DEATH_SCORE = -1;

        for (int i = 0; i < numOfPlayers; i++) {
            int currentPlayerSpecialDiceNumber = findSpecialDiceNumber(i);
            if (currentPlayerSpecialDiceNumber == 0) {
                continue;
            }

            List<Integer> findTargetPlayerIndex = findTargetPlayerIndex(i); // 타겟인덱스의 리스트

            GameScore2 currentGameScore = playersList.get(i).getGamescore2();

            GameScore2[] targetGameScore = new GameScore2[(numOfPlayers - 1)];
            for (int j = 0; j < (numOfPlayers - 1); j++) {
                targetGameScore[j] = playersList.get(findTargetPlayerIndex.get(j)).getGamescore2();
            }

            switch (currentPlayerSpecialDiceNumber) {
                case STEAL:

                    for (int k = 0; k < (numOfPlayers - 1); k++) {
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

    public int getNumOfPlayers() {
        return numOfPlayers;
    }

    public void printResult() {
        for (int i = 0; i < numOfPlayers; i++) {
            System.out.println(playersList.get(i));
        }
    }

    public void checkWinner() {

        // 최종 점수에 대한 리스트 생성
        List<Integer> finalGameScoreList = new ArrayList<>();

        for (int i = 0; i < numOfPlayers; i++) {
            finalGameScoreList.add(playersList.get(i).getGamescore2().getGameScore());
        }

        // 리스트에 각 플레이어의 총합을 넣은 후 정렬
        Collections.sort(finalGameScoreList, Collections.reverseOrder());

        // 1위부터 각 등수에 해당하는 플레이어 이름 매칭(?)
        Map<Integer, String> winnerPlayerMap = new HashMap<>();
        for (int i = 0; i < numOfPlayers; i++) {
            for (int j = 0; j < numOfPlayers; j++) {
                if (finalGameScoreList.get(i) == playersList.get(j).getGamescore2().getGameScore()) {
                    winnerPlayerMap.put((i + 1), playersList.get(j).getName());
                }
            }
        }

        // 플레이어 순위 출력
        // 동일한 점수가 나오면 마지막에 들어온 value 값으로 저장됨
        // TODO : 무승부에 대한 승자판정 보완 필요
        for(int k = 0; k < numOfPlayers; k++){
            System.out.println((k+1) + "등 플레이어: " + winnerPlayerMap.get((k+1)));
        }

        // 배열로 순위를 만들어본 코드
//      String[] rank = new String[numOfPlayers];
//
//      for(int i = 0; i < numOfPlayers; i++){
//          for(int j = 0; j < numOfPlayers; j++){
//              if(finalGameScoreList.get(i) == playersList.get(j).getGamescore2().getGameScore()){
//                  rank[i] = playersList.get(j).getName();
//
//              }
//          }
//          System.out.println((i + 1) + "등 플레이어: " + rank[i]);
//      }

    }
}