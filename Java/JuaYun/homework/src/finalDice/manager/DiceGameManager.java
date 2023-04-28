package finalDice.manager;

import finalDice.dice.RefactorDice;
import finalDice.player.DiceGamePlayer;
import finalDice.score.RefactorScore;
import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class DiceGameManager {
    final private int PLAYER_NUM = 3;
    final private List<DiceGamePlayer> playerList = new ArrayList<>();

    public DiceGameManager() {
        for (int i = 0; i < PLAYER_NUM; i++) {
            // playerList는 플레이어를 가져야해
            playerList.add(new DiceGamePlayer("플레이어" + (i + 1)));
            System.out.println(playerList.get(i));
        }
    }
    //// -------- 여기까지하면 첫번째 조건과 플레이어 3명과 그 3명에게 할당된 주사위의 값과 그 주사위의 합산값이 나옴 ----------

    // 다른 플레이어 찾기
    private int findTargetPlayerIndex (int currentPlayerIdx) {
        int targetPlayerIdx = 0;

        do {
            targetPlayerIdx = CustomRandom.generateNumber(PLAYER_NUM - 1);
            // 현재 플레이어 인덱스와 타겟플레이어 인덱스가 같다면 조건문을 다시 돌려라
            // 현재 플레이어와 다른 플레이어를 찾는 조건문
        } while (currentPlayerIdx == targetPlayerIdx);

        return targetPlayerIdx;
    }

    // 세 번째 주사위의 조건을 만들어주기
    private int findSpecialDiceNumber (int playerIndex) {
        final int ARRAY_BIAS = 1;
        final int SPECIAL_DICE_INDEX = 3 - ARRAY_BIAS;

        RefactorDice currentPlayerSpecialDice =
                // currentPlayerSpecialDice 값이 null 값인지 유효한 값인지 판정해주거같음
                playerList.get(playerIndex).getSelectedGameDice(SPECIAL_DICE_INDEX);

        if (currentPlayerSpecialDice == null) { return 0; }

        // currentPlayerSpecialDice 가 유효한 값이라면
        // currentPlayerSpecialDiceNumber 반환
        int currentPlayerSpecialDiceNumber =
                currentPlayerSpecialDice.getDiceNumber();
        return currentPlayerSpecialDiceNumber;
    }

    // 직접 생성한 매서드같음
    public void playGame() {
        for (int currentPlayerIdx = 0; currentPlayerIdx < PLAYER_NUM; currentPlayerIdx++) {
            final int currentPlayerSpecialDiceNumber = findSpecialDiceNumber(currentPlayerIdx);

            if (currentPlayerSpecialDiceNumber == 0 ) { continue; }
            final RefactorScore currentPlayerScore = playerList.get(currentPlayerIdx).getGameScore();

            // 이미 형성되있는 매서드 private void applyAbilityOfSpecialDice 를 깔끔하게 하기 위해
            // 이런식으로 정리하고 밑으로 매서드를 뺐음
            applyAbilityOfSpecialDice(currentPlayerIdx, currentPlayerSpecialDiceNumber, currentPlayerScore);
        }
    }

    private void applyAbilityOfSpecialDice(
            int currentPlayerIdx, int currentPlayerSpecialDiceNumber, RefactorScore currentPlayerScore) {

        final int STEAL = 1;
        final int BUFF = 3;
        final int DEATH = 4;
        final int STEAL_SCORE = 3;
        final int BUFF_SCORE = 2;
        final int DEATH_SCORE = -1;

        switch (currentPlayerSpecialDiceNumber) {
            case STEAL:
                final int targetPlayerIndex = findTargetPlayerIndex(currentPlayerIdx);
                final RefactorScore targetPlayerScore = playerList.get(targetPlayerIndex).getGameScore();
            case BUFF:
            case DEATH:
        }
    }
}