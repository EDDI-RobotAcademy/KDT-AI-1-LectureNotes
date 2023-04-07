package finalDice.manager;

import finalDice.dice.RefactorDice;
import finalDice.player.RefactorDiceGamePlayer;
import finalDice.score.RefactorScore;
import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FinalDiceGameManager {
    final private int PLAYER_NUM = 3;
    final private List<RefactorDiceGamePlayer> refactorPlayerList = new ArrayList<>();

    public FinalDiceGameManager() {
        for (int i = 0; i < PLAYER_NUM; i++) {
            refactorPlayerList.add(new RefactorDiceGamePlayer("플레이어" + (i + 1)));
            System.out.println(refactorPlayerList.get(i));
        }
    }

    private int findTargetPlayerIndex (int currentPlayerIndex) {
        // 상대편 찾기 (1:1 상황)
        // 이것도 1:1 아닌 경우를 위한 확장성 문제 대비 필요
        // -> do-while문이 좋겠다
        int targetPlayerIndex = 0;

        do {
            targetPlayerIndex = CustomRandom.generateNumber(PLAYER_NUM-1);
        } while (currentPlayerIndex == targetPlayerIndex);
        // while의 조건이 참이면 계속 루프돌음
        // 여기서 두 인덱스가 같다면 자살 공격을 하지 않는다는 것도 설정됨
//
//        if (currentPlayerIndex == 0) {
//            targetPlayerIndex = 1;
//        }
//
        return targetPlayerIndex;
    }

    private int findSpecialDiceNumber (int playerIndex) {
        final int ARRAY_BIAS = 1;
        final int SPECIAL_DICE_INDEX = 3 - ARRAY_BIAS;

        RefactorDice currentPlayerSpecialRefactorDice =
                refactorPlayerList.get(playerIndex).getSelectedGameDice(SPECIAL_DICE_INDEX);

        if (currentPlayerSpecialRefactorDice == null) { return 0; }

        int currentPlayerSpecialDiceNumber =
                currentPlayerSpecialRefactorDice.getDiceNumber();

        return currentPlayerSpecialDiceNumber;
    }

    public void playGame() { // 너무 기니까 스위치 문 메서드로 빼주자

        for (int currentPlayerIdx = 0; currentPlayerIdx < PLAYER_NUM; currentPlayerIdx++) {
            final int currentPlayerSpecialDiceNumber =
                    findSpecialDiceNumber(currentPlayerIdx);

            if (currentPlayerSpecialDiceNumber == 0) { continue; }

            // 확장성이 떨어지므로 개선 필요 -> 상대편 찾기 (1:1 상황)
            // 자기 자신이 아닌 상대편을 탐색하도록 (1:1 아닌 경우 대응) - 완료
            final RefactorScore currentPlayerScore =
                    refactorPlayerList.get(currentPlayerIdx).getGameScore();

            applyAbilityOfSpecialDice(
                    currentPlayerIdx, currentPlayerSpecialDiceNumber, currentPlayerScore);
        }
    }

    private void applyAbilityOfSpecialDice(
            int currentPlayerSpecialDiceNumber,
            int currentPlayerIdx,
            RefactorScore currentPlayerScore) {

        final int STEAL = 1;
        final int BUFF = 3;
        final int DEATH = 4;

        final int STEAL_SCORE = 3;
        final int BUFF_SCORE = 2;
        final int DEATH_SCORE = -1;

        switch (currentPlayerSpecialDiceNumber) { // -> 여기서 광역공격 해결 가능
            case STEAL:
                final int targetPlayerIndex = findTargetPlayerIndex(currentPlayerIdx);
                final RefactorScore targetPlayerScroe =
                        refactorPlayerList.get(targetPlayerIndex).getRefactorScore();
                targetPlayerScroe.takeScore(currentPlayerScore, STEAL_SCORE);
                break;

            case BUFF:
                currentPlayerScore.addScore(BUFF_SCORE);
                break;

            case DEATH:
                currentPlayerScore.loseAll(DEATH_SCORE);
                break;
        }
    }

    public void printResult() {
        for (int i = 0; i < PLAYER_NUM; i++) {
            System.out.println(refactorPlayerList.get(i));
        }
    }

    public void checkWinner() {
        // 확장성 문제가 존재함 추후 사용자 숫자 증대시 리팩토링 필요
        // 여기도 1:1 상황에 최적화 되어 있기 때문에 고쳐줘야 함

        // 체크 위너이기 때문에 말 그대로 승자 판정 필요 - 승리랑 무승부만 체크해주면 됨
        // 일단 승리 부터 출력
        // winner라는 변수를 선언해 주어야 겠구나 - 플레이어 클래스에서 불러와야 한다로 이어짐
        // 여기서 위너가 되려면 가능한 인덱스 선언 - WINNER_IDX

        // 또 판정해줘야 할 것이 바로 무승부
        // compare이용해서 해야 함

        final int WINNER_IDX = 0;
        final int SECOND_IDX = 0;

        final int DRAW = 0;

        RefactorDiceGamePlayer winner = refactorPlayerList.get(WINNER_IDX);
        RefactorDiceGamePlayer second = refactorPlayerList.get(SECOND_IDX);

        if (winner.compareTo(second) == DRAW) {
            System.out.println("무승부!");
            return; // 여기서 return 안해주면 아래로 내려가서 승리자 구하기 때문에 넣어줘야함
        }

        Collections.sort(refactorPlayerList, Collections.reverseOrder());

        System.out.println("승리: " + winner.getName());
        System.out.println("전적 상황: " + refactorPlayerList);
    }
}
