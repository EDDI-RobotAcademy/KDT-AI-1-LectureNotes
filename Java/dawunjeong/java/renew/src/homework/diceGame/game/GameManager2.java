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

        // 0. 선생님 풀이
        /*
        final int WINNER_IDX = 0;
        final int SECOND_IDX = 1;

        final int DRAW = 0;
        Collections.sort(playersList, Collections.reverseOrder());
        Player2 winner = playersList.get(WINNER_IDX);

        // 무승부
        Player2 second = playersList.get(SECOND_IDX);

        if (winner.compareTo(second) == DRAW) {
            System.out.println("무승부!");
            return;
        }

        System.out.println("승리: " + winner.getName());
        System.out.println("전적 상황: " + playersList);
        */

        // 1. 배열 이용해서 위너 찾기
        // TODO: 플레이어 1번과 3번이 동일하게 1등일 때 플레이어 2번이 3등으로 출력되는 오류가 있음
        /*
        int[] rank = new int[numOfPlayers];

        for(int i = 0; i < numOfPlayers; i++) {
            for(int j = 0; j < numOfPlayers; j++) {
                if(i == j) {continue;}

                if(playersList.get(i).getGamescore2().getTotalScore() < playersList.get(j).getGamescore2().getTotalScore()) {
                    rank[i]++;
                }
            } System.out.println(playersList.get(i).getName() + "의 등수는 " + (rank[i]+1) + "등 입니다.");
        }
        */

        // 2. 맵을 이용하여 위너 찾기
    	// 최종 점수에 대한 리스트 생성
        List<Integer> finalGameScoreList = new ArrayList<>();
        int preScore = -777;

        // TODO: finalGameScoreList.get(0)과 finalGameScoreList.get(2)의 값이 동일할 때는 걸러지지 않음
        // 즉 인덱스 i의 값과 i + 2 이상의 값이 동일할 때 오류가 발생함
        for (int i = 0; i < numOfPlayers; i++) {
            int currentScore = playersList.get(i).getGamescore2().getTotalScore();
            if (currentScore != preScore) {
                finalGameScoreList.add(playersList.get(i).getGamescore2().getTotalScore());
            }
            preScore = currentScore;
        }

        // finalGameScoreList가 몇 칸 생성되었는지 확인
        System.out.println(finalGameScoreList.size());

        // 리스트에 각 플레이어의 총합을 넣은 후 정렬
        Collections.sort(finalGameScoreList, Collections.reverseOrder());

        // Map을 사용하여 각 플레이어 이름과 등수를 매칭
        Map<String, String> rankPlayerName = new LinkedHashMap<>();

        for(int i = 0; i < finalGameScoreList.size(); i++) {
        	for(int j = 0; j < playersList.size(); j++) {
        		if(finalGameScoreList.get(i) == playersList.get(j).getGamescore2().getTotalScore()) {
        			rankPlayerName.put(playersList.get(j).getName(), ((i+1) + "등"));
        		}
        	}
        } System.out.println(rankPlayerName);

        // 원하는 플레이어의 등수를 확인해보기
        System.out.println("플레이어2의 등수는 " + rankPlayerName.get("플레이어2"));
    }
}