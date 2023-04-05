package homework.diceGame.game;

import java.util.*;

public class GameManager2 {

    int numOfPlayers;
    List<Player2> playersList = new ArrayList<>();

    public GameManager2() {
        // 플레이어 수 입력받기
        Scanner scan = new Scanner(System.in);
        System.out.println("플레이어의 수를 입력하세요.");
        numOfPlayers = scan.nextInt();

        // 플레이어 객체 생성 후 리스트에 넣기
        for (int i = 0; i < numOfPlayers; i++) {
            playersList.add(new Player2("플레이어" + (i + 1)));
            System.out.println(playersList.get(i));
        }
    }

    // 타겟 인덱스 찾는 매서드
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

    // 플레이어의 스페셜 다이스를 찾는 매서드
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

    // 게임 매서드
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

            List<Integer> findTargetPlayerIndex = findTargetPlayerIndex(i);

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

        int[] rank = new int[numOfPlayers];

        for(int i = 0; i < numOfPlayers; i++) {
            for(int j = 0; j < numOfPlayers; j++) {
                if(i == j) {continue;}

                if(playersList.get(i).getGamescore2().getTotalScore() < playersList.get(j).getGamescore2().getTotalScore()) {
                    rank[i]++;
                }
            } System.out.println(playersList.get(i).getName() + "의 등수는 " + (rank[i]+1) + "등 입니다.");
        }


//    	// 최종 점수에 대한 리스트 생성
//        List<Integer> finalGameScoreList = new ArrayList<>();
//        int preScore = -777;
//
//        for (int i = 0; i < numOfPlayers; i++) {
//        	int currentScore = playersList.get(i).getGamescore().getGameScore();
//        	if (currentScore != preScore) {
//        		finalGameScoreList.add(playersList.get(i).getGamescore().getGameScore());
//
//        	} preScore = currentScore;
//        }
//
//        System.out.println(finalGameScoreList.size());
//
//        // 리스트에 각 플레이어의 총합을 넣은 후 정렬
//        Collections.sort(finalGameScoreList, Collections.reverseOrder());
//
//        Map<String, Integer> rankPlayerName = new LinkedHashMap<>();
//
//        for(int i = 0; i < finalGameScoreList.size(); i++) {
//        	for(int j = 0; j < playersList.size(); j++) {
//        		if(finalGameScoreList.get(i) == playersList.get(j).getGamescore().getGameScore()) {
//        			rankPlayerName.put(playersList.get(j).getName(), i);
//
//        		}
//        	}
//        } System.out.println(rankPlayerName);

    }

}