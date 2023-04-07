package diceGame.game;

import diceGame.player.Player;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    // 필드
    final private int PLAYER_NUM = 2; //-> 플레이어 명 수
    final private List<Player> playerList = new ArrayList<>();

    // 생성자
    public GameManager() {
        for (int i = 0; i < PLAYER_NUM; i++) {
            // 생성하면서 플레이어 만들어준다.
            playerList.add(new Player("플레이어" + (i+1)));
            System.out.println(playerList.get(i));
        }
    }

    // 메서드
    public void playGame() {
        final int STEAL = 1;
        final int BUFF = 3;
        final int DEATH = 4;

        final int STEAL_SCORE = 3;
        final int BUFF_SCORE = 2;
        final int DEATH_SCORE = -1;

        for (int i = 0; i < PLAYER_NUM; i++) {
            // 각 플레이어의 마지막 주사위가 들어있는 변수
            int currentPlayerSpecialDiceNumber = findSpecialDiceNumber(i);

            if (currentPlayerSpecialDiceNumber == 0) { continue; }

            // TODO: 확장성이 떨어지므로 개선 필요 -> 상대편 찾기 (1:1 상황)
            int targetPlayerIndex = findTargetPlayerIndex(i);

            GameScore targetPlayerScore =
                    playerList.get(targetPlayerIndex).getGameScore();
            // 상대방 총합 점수 받아온다.

            GameScore currentPlayerScore =
                    playerList.get(i).getGameScore();
            // 내 총합 점수 받아온다.


            // 세번째 주사위의 조건문 돌리기
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

    private int findSpecialDiceNumber (int playerIndex) {
        final int ARRAY_BIAS = 1;
        final int SPECIAL_DICE_INDEX = 3 - ARRAY_BIAS;

        Dice currentPlayerSpecialDice =
                playerList.get(playerIndex).getSelectedGameDice(SPECIAL_DICE_INDEX);
        // 각 플레이어의 마지막 주사위 값(이긴 한데, 객체로 받아왔음)을 받아온다.

        if (currentPlayerSpecialDice == null) { return 0; }
        // 만약 3번째 수가 없다면 0 리턴하라는 뜻

        int currentPlayerSpecialDiceNumber =
                currentPlayerSpecialDice.getDiceNumber();
        // 객체로 받아온 것을 getDiceNumber로 int로 받아옴

        return currentPlayerSpecialDiceNumber;
    }

    private int findTargetPlayerIndex (int currentPlayerIndex) {
        // 상대편 찾기 (1:1 상황)
        int targetPlayerIndex = 0;

        if (currentPlayerIndex == 0) {
            targetPlayerIndex = 1;
        }

        return targetPlayerIndex;
    }

    public void printResult() {
        for (int i = 0; i < PLAYER_NUM; i++) {
            System.out.println("?? -> "+playerList.get(i));

        }
    }

    public void checkWinner() {
        // TODO: 확장성 문제가 존재함 추후 사용자 숫자 증대시 리팩토링 필요
        GameScore firstPlayerScore = playerList.get(0).getGameScore();
        GameScore secondPlayerScore = playerList.get(1).getGameScore();

        final int firstPlayerScoreTotalScore  = firstPlayerScore.getTotalScore();
        final int secondPlayerScoreTotalScore  = secondPlayerScore.getTotalScore();

        if (firstPlayerScoreTotalScore > secondPlayerScoreTotalScore) {
            System.out.println("승자: " + playerList.get(0).getName());
            return;
        }
        if (firstPlayerScoreTotalScore < secondPlayerScoreTotalScore) {
            System.out.println("승자: " + playerList.get(1).getName());
            return;
        }

        System.out.println("무승부");
    }
}