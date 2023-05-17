package kr.eddi.demo.vue.problem.dice;


import kr.eddi.demo.vue.problem.player.Player;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class DiceGameManager {

    private List<Player> playerList;

    public DiceGameManager(int diceMaxNumber) {
        playerList = new ArrayList<>();

        playerList.add(new Player(diceMaxNumber));
    }

    /* 멀티 플레이 */
    public DiceGameManager(int playerNum, int diceMaxNumber) {
        playerList = new ArrayList<>();

        final int CONDITION_DICE_IDX = 0;

        for (int i = 0; i < playerNum; i++) {
            final Player player = new Player(diceMaxNumber, CONDITION_DICE_IDX, (i + 1));
            playerList.add(player);
        }
    }

    public String checkWinIfSumEven (int playerDiceSumResult) {
        final int DECISION_WIN = 2;
        final int EVEN = 0;

        if (playerDiceSumResult % DECISION_WIN == EVEN) {
            return "Win!";
        }

        return "Lose!";
    }
    public String checkWinner () {
        final Player firstPlayer = playerList.get(0);
        final int firstPlayerScore = firstPlayer.getDiceSum();

        final Player secondPlayer = playerList.get(1);
        final int secondPlayerScore = secondPlayer.getDiceSum();

        if (firstPlayerScore > secondPlayerScore) {
            return "winner: " + firstPlayer.getName();
        }
        if (firstPlayerScore < secondPlayerScore) {
            return "winner: " + secondPlayer.getName();
        }

        return "draw";
    }


    public int calculatePlayerDiceSum() {
        final List<Dice> currentPlayerDiceList = playerList.get(0).getDiceList();

        int tmpSum = 0;
        for (int i = 0; i < currentPlayerDiceList.size(); i++) {
            tmpSum += currentPlayerDiceList.get(i).getDiceNumber();
        }
        return tmpSum;
    }
    public void applyCondition () {
        //조건 주사위를 적용 합니다.
        final int CONDITION_DICE_IDX = 2;
        //3번째 주사위의 특수 효과가 있어서 2임
        final int STEAL = 1;
        final int BUFF = 3;
        final int DEATH = 4;
        //각각 1,3,4 가 나올때 특수 효과가 있습니다.
        final int STEAL_SCORE = 3;
        //스틸의 경우 3점
        final int BUFF_SCORE = 2;
        //버프의 경우 2점
        final int DEATH_SCORE = -777;
        //데스의 경우 -777점 입니다.

        //위에서 만들어진 플레이어 리스트를 가져옵니다.
        for (int i = 0; i < playerList.size(); i++) {
            //두명이니까 두번 진행합니다.
            final Player currentPlayer = playerList.get(i);
            //현재 플레이하는 플레이어 입니다.
            final int currentPlayerDiceSum = currentPlayer.getDiceSum();
            //현재 플레이어의 합산 점수 입니다.

            final Dice currentPlayerDice = currentPlayer.getDice(CONDITION_DICE_IDX);
            //new Dice 아니라서 랜덤 아님- 현재 플레이어에서 3번째 주사위 가져옵니다.
            if (currentPlayerDice == null) {
                continue;
            }
            // 첫주사위가 짝수라 3번째 주사위가 없으면 그냥 속행 한다.

            final int conditionDiceNumber = currentPlayerDice.getDiceNumber();
            //3번째 주사위가 있기 때문에 getDiceNumber()로 가져온다.
            switch (conditionDiceNumber) {
                //가져온 숫자가 아래의 케이스와 같을 경우 특수 효과 방동된다.
                case STEAL:
                    //타겟 찾아오기
                    final int targetPlayerIdx = findTargetPlayerIdx(i);
                    //타겟 정해짐
                    final Player targetPlayer = playerList.get(targetPlayerIdx);
                    //타겟 플레이어 정보 가져온다.
                    final int targetDiceSum = targetPlayer.getDiceSum();
                    //타겟 플레이어의 총합 가져온다.

                    currentPlayer.setDiceSum(currentPlayerDiceSum + STEAL_SCORE);
                    //현재 플레이어에 3더하고
                    targetPlayer.setDiceSum(targetDiceSum - STEAL_SCORE);
                    // 타겟 플레이어에 3빼준다.
                    break;
                //
                case BUFF:
                    currentPlayer.setDiceSum(currentPlayerDiceSum + BUFF_SCORE);
                    break;
                    //현재 플레이어 점수에 2점 더하기

                case DEATH:
                    currentPlayer.setDiceSum(DEATH_SCORE);
                    //현재 플레이어 점수 -777로 셋
                    break;
            }
        }
    }
    public int findTargetPlayerIdx (int currentPlayerIdx) {
        if (currentPlayerIdx == 0) {
            return 1;
        }
        // 2명이기때문에 0번일때 1반환
        // 1일때 0 반환해준다.

        return 0;
    }
}