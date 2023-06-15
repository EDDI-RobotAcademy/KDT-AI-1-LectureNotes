package review1.dawun;

import java.util.ArrayList;
import java.util.List;

public class ReviewGameManager6 {
    int numOfPlayers = 3;
    List<ReviewPlayer6> playersList = new ArrayList<>();


    public ReviewGameManager6() {
        for (int i = 0; i < numOfPlayers; i++) {
            playersList.add(new ReviewPlayer6("플레이어" + (i + 1)));
            System.out.println(playersList.get(i));
        }
    }

    public int[] findTargetPlayerIndex(int currentPlayerIndex) {
        int[] targetPlayerIndexArray = new int[numOfPlayers];
        int i;

        for(i = 0; i < numOfPlayers; i++){
            if (i == currentPlayerIndex) { continue; }
            targetPlayerIndexArray[i] = i;
        }

        return targetPlayerIndexArray;
    }

    public int findSpecialDiceNumber(int PlayerIndex) {
        final int ARRAY_BIAS = 1;
        final int SPECIAL_DICE_INDEX = 3 - ARRAY_BIAS;

        ReviewDice6 currentPlayerSpecialDice =
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

            // 예상대로 이 파트가 문제였습니다.
            // 실제 디버깅 상황에서는 [2, 3]이 출력되어 문제가 되었습니다.
            // 배열 [3]은 네 번째 요소로 판정하기 때문입니다.
            int[] targetPlayerIndex = findTargetPlayerIndex(i);

            ReviewGameScore6 currentGameScore = playersList.get(i).getGameScore6();

            // 플레이어 수의 -1만큼 target score 배열
            // 배열은 선언할 때 사용할 개수를 적습니다.
            // 사용할 때는 입력 개수 - 1 만큼 사용합니다.
            ReviewGameScore6[] targetGameScore = new ReviewGameScore6[numOfPlayers - 1];
            for (int j = 0; j < numOfPlayers - 1; j++) {
                targetGameScore[j] = playersList.get(targetPlayerIndex[j]).getGameScore6();
            }

            switch (currentPlayerSpecialDiceNumber) {
                case STEAL:
                    // target들의 값을 모두 뺏어와야 함
                    // target의 수는 플레이어 수의 -1
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

    public void printResult() {
        for (int i = 0; i < numOfPlayers; i++) {
            System.out.println(playersList.get(i));
        }
    }
}
