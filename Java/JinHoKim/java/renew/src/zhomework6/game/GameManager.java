package zhomework6.game;

import zhomework6.player.Player;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    final private int PLAYER_NUM = 2; // 게임하는 플레이어 숫자
    final private List<Player> playerList = new ArrayList<>();

    public GameManager() {
        for (int i = 0; i < PLAYER_NUM; i++) {
            playerList.add(new Player("플레이어" + (i+1))); // 플레이어 1 2 만들기
            System.out.println(playerList.get(i)); // 플레이어 1, 2 출력
        }
    }

    private int findTargetPlayerIndex(int currentPlayerIndex) {
        int targetPlayerIndex = 0; // 인덱스 0번째 플레이어
        if (currentPlayerIndex == 0) {
            targetPlayerIndex = 1;
        }
        return targetPlayerIndex;
    }

    private int findSpecialDiceNumber(int playerIndex) { // 주사위 세번째 인덱스 위치 주사위 찾기?
        final int ARRAY_BIAS = 1; //?
        final int SPECIAL_DICE_INDEX = 3 - ARRAY_BIAS; //스페셜 주사위 인덱스가 2 -> 3번째 주사위를 가리킴 인덱스는 0 부터 시작 인덱스 3는 3번째 주사위를 말함

        Dice currentPlayerSpecialDice = playerList.get(playerIndex).getSelectedGameDice(SPECIAL_DICE_INDEX);
        // 들어온 플레이어 의 세번째 주사위
        if (currentPlayerSpecialDice == null) {
            return 0;
        }
        int currentPlayerSpecialDiceNumber = currentPlayerSpecialDice.getDiceNumber();
        //현재 플레이어의 3번째 주사위의 숫자가 들어온 플레기어의 현재 주사위의 값과 같으면
        return currentPlayerSpecialDiceNumber;
    }

    public void playGame() {
        final int STEAL = 1; // 주사위 숫자가 1인경우 -> 친구에게 점수 3점 뺏음
        final int BUFF = 3; // 주사위 숫자가 3인경우 -> 자기자신에게 2점 가산
        final int DEATH = 4; // 주사위 숫자가 4인 -> 무조건 패배
        final int STEAL_SCORE = 3;
        final int BUFF_SCORE = 2;
        final int DEATH_SCORE = -1;

        for (int i = 0; i < PLAYER_NUM; i++) {
            int currentPlayerSpecialDiceNumber = findSpecialDiceNumber(i);
            if (currentPlayerSpecialDiceNumber == 0) { // 세번째 주사위값이 0이면
                continue;
            }
            int targetPlayerIndex = findTargetPlayerIndex(i);

            GameScore targetPlayerScore = playerList.get(targetPlayerIndex).getGameScore();

            GameScore currentPlayerScore = playerList.get(i).getGameScore();

            switch (currentPlayerSpecialDiceNumber) {
                case STEAL:// 세 번째 주사위가 1인경우
                    targetPlayerScore.takeScore(currentPlayerScore, STEAL_SCORE);
                    break;
                case BUFF://세 번째 주사위가 3인경우
                    currentPlayerScore.addScore(BUFF_SCORE);
                    break;
                case DEATH:
                    currentPlayerScore.loseAll(DEATH_SCORE);
                    break;
            }
        }

    }

    public void printResult() { // 플레이어 1 2 출력
        for (int i = 0; i < PLAYER_NUM; i++) {
            System.out.println(playerList.get(i));
        }
    }

    public void checkWinner() {
        GameScore firstPlayerScore = playerList.get(0).getGameScore();
        GameScore secondPlayerScore = playerList.get(1).getGameScore();

        final int firstPlayerScoreTotalScore = firstPlayerScore.getTotalScore();
        final int secondPlayerScoreTotalScore = secondPlayerScore.getTotalScore();

        if (firstPlayerScoreTotalScore > secondPlayerScoreTotalScore) {
            System.out.println("승자" + playerList.get(0).getName());
            return;
        }

        if (firstPlayerScoreTotalScore < secondPlayerScoreTotalScore) {
            System.out.println("승자" + playerList.get(1).getName());
            return;
        }

        System.out.println("무승부");
    }


}
