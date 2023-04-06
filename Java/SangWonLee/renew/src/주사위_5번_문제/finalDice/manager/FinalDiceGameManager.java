package 주사위_5번_문제.finalDice.manager;

import 주사위_5번_문제.finalDice.dice.RefactorDice;
import 주사위_5번_문제.finalDice.player.RefactorDiceGamePlayer;
import 주사위_5번_문제.finalDice.score.RefactorScore;
import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FinalDiceGameManager {
    final private int PLAYER_NUM = 3;
    final private List<RefactorDiceGamePlayer> playerList = new ArrayList<>();

    public FinalDiceGameManager() {
        // 생성자 호출을 하였을 때,
        for (int i = 0; i < PLAYER_NUM; i++) {
            playerList.add(new RefactorDiceGamePlayer("플레이어" + (i + 1)));
            System.out.println(playerList.get(i));
        } // 플레이어 리스트에. 플레이어 클래스 저장

        System.out.println(playerList); // 어떻게 저장되는지 확인용
    }


    private int findTargetPlayerIndex(int currentPlayerIdx) {
        int targetPlayerIdx = 0;

        do {
            targetPlayerIdx = CustomRandom.generateNumber(PLAYER_NUM - 1);
            // 상대 플레이어 Index가 0,1,2 중 하나.
        } while (currentPlayerIdx == targetPlayerIdx);
        // 만약 플레이어 index랑 상대 index가 같다면 반복해서 다시 숫자를 정하자
        return targetPlayerIdx;
    }

    private int findSpecialDiceNumber(int playerIndex) {
        final int ARRAY_BIAS = 1;
        final int SPECIAL_DICE_INDEX = 3 - ARRAY_BIAS; // 스페셜 다이스 인덱스 번호 (2)

        RefactorDice currentPlayerSpecialDice = playerList.get(playerIndex).getSelectedGameDice(SPECIAL_DICE_INDEX);
        // 플레이어 리스트에서 매개변수로 가져온 Index로 2번째 주사위를 얻는다.
        if (currentPlayerSpecialDice == null) {
            return 0;
        }
        // 세번째 주사위가 없다면 0

        int currentPlayerSpecialDiceNumber = currentPlayerSpecialDice.getDiceNumber();
        // 세번째 주사위 숫자를 인트로 바꿔서 리턴

        return currentPlayerSpecialDiceNumber;
    }

    public void playGame() {
        for (int currentPlayerIdx = 0; currentPlayerIdx < PLAYER_NUM; currentPlayerIdx++) {
            // 현재 플레이어 인덱스만큼
            final int currentPlayerSpecialDiceNumber = findSpecialDiceNumber(currentPlayerIdx);
            // 현재 플레이어 인덱스로 특별주사위 숫자를 저장

            if (currentPlayerSpecialDiceNumber == 0) {
                continue;
            }
            // 만약 세번째 주사위가 0이면 위로

            final RefactorScore currentPlayerScore = playerList.get(currentPlayerIdx).getGameScore();
            // 현재 플레이어 게임스코어 변수 지정

            applyAbilityOfSpecialDice(currentPlayerIdx, currentPlayerSpecialDiceNumber, currentPlayerScore);
            // 현재 플레이어 Index, 스페셜 주사위 넘버, 현재 플레이어 스코어를
            // 인자로 넘기기
        }
    }

    private void applyAbilityOfSpecialDice(int currentPlayerIdx, int currentPlayerSpecialDiceNumber, RefactorScore currentPlayerScore) {
        // 위에서 가져온 인자를 매개변수로,
        final int STEAL = 1;
        final int BUFF = 3;
        final int DEATH = 4;

        final int STEAL_SCORE = 3;
        final int BUFF_SCORE = 2;
        final int DEATH_SCORE = -1;

        switch (currentPlayerSpecialDiceNumber) { // 스페셜 주사위 넘버가
            case STEAL: // 1 일때,
                final int targetPlayerIndex = findTargetPlayerIndex(currentPlayerIdx);
                // 현재 플레이어 Index를 인자로 가져가서
                // 현재 플레이어 index가 아닌 다른 플레이어 index를 찾아옴
                final RefactorScore targetPlayerScore = playerList.get(targetPlayerIndex).getGameScore();
                // 상대 플레이어 index로 게임스코어를 받아서 상대 점수에 저장.
                targetPlayerScore.takeScore(currentPlayerScore, STEAL_SCORE);
                // 플레이어 스코어, 훔칠 점수를 인자로 targetPlayerScore.takeScore(상대 점수)로 감
                // 그래서 this가 상대 점수가 되는 거네 ㅇㅇ.....

                // 아직 playGame()의 for문이 안끝난 상태임.
                break;

            case BUFF: // 3 일때,
                currentPlayerScore.addScore(BUFF_SCORE);
                // 현재 점수로 버프 점수를 가지고 addScore 감

                break;

            case DEATH: // 4 일때,
                currentPlayerScore.loseAll(DEATH_SCORE);
                // 현재 점수로 죽을 점수( -1 )를 가지고 loseAll로 감

                break;

            //@@@@@@@ 여기까지가 이제 playGame이 끝났다. @@@@@@@

        }
    }

    public void printResult() {
        for (int i = 0; i < PLAYER_NUM; i++) {
            System.out.println(playerList.get(i));
        }
        // 스페셜 주사위로 바뀐 점수를 출력
    }

    public void checkWinner() {

        final int WINNER_IDX = 0;
        final int SECOND_IDX = 1;

        final int DRAW = 0;
        // RefactorPlayer가 Comparable<RefactorPlayer>를 가지고 있어야 하는데
        // Comparable<RefactorPlayer>가 없는데 왜 자꾸 sort 하려고 하냐면서 화내는 모습
        // class diceGame.player.RefactorPlayer cannot be cast to class java.lang.Comparable
        // (diceGame.player.RefactorPlayer is in unnamed module of loader 'app';
        Collections.sort(playerList, Collections.reverseOrder());
        // playList를 total 스코어 점수가 높은 순서대로 나열함.


        RefactorDiceGamePlayer winner = playerList.get(WINNER_IDX);
        // 승자는 맨 앞에있는 사람

        // 무승부
        RefactorDiceGamePlayer second = playerList.get(SECOND_IDX);
        // 두번째 있는 사람

        if (winner.compareTo(second) == DRAW) { // 첫번째랑 두번째랑 같으면
            System.out.println("무승부!");
            return; // 무승부 출력 되면 끝내기
        }

        System.out.println("승리: " + winner.getName()); // 무승부 출력 안되면 승자 출력
        System.out.println("전적 상황: " + playerList);
    }
}