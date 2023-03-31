package homework.diceThirdGame;

import diceGame.player.Player;

import java.util.Arrays;

public class DiceGame {
    final private DicePlayer player1 = new DicePlayer("Cat"); //게임을 하려면 사용자가 2명 필요함
    final private DicePlayer player2 = new DicePlayer("Dog");
    private int totalScore1 = 0;
    private int totalScore2 = 0;
    private int[] diceArray1;
    private int[] diceArray2;
    final private int DICE_MAX_NUM = 3;
    private DiceScore gameScore;

    public DiceGame(){
        diceArray1 = new int[DICE_MAX_NUM]; //주사위 3개를 넣을 배열 생성
        diceArray2 = new int[DICE_MAX_NUM]; //주사위 3개를 넣을 배열 생성
    }

    public void gamePlay() {
        final int ODD = 1;
        final int CONDITION_NUM = 2;
        final int FIRST_CHECK_NUMBER = 0;

        //플레이어 1
        for(int i = 0; i < DICE_MAX_NUM; i++){
            diceArray1[i] = player1.rollDice(i);

            // 총 합계
            totalScore1 += diceArray1[i];

//            int diceNumberSum = diceArray1[i];
//            gameScore = new DiceScore(diceNumberSum);

            if(diceArray1[FIRST_CHECK_NUMBER] % CONDITION_NUM == ODD){
                break;
            }
        }

        //플레이어 2
        for(int i = 0; i < DICE_MAX_NUM; i++){
            diceArray2[i] = player2.rollDice(i);

            // 총 합계
            totalScore2 += diceArray2[i];

            if(diceArray2[FIRST_CHECK_NUMBER] % CONDITION_NUM == ODD){
                break;
            }
        }



        // 이렇게 되면 어떤 기준으로 표적이 되고, 공격자가 되는지 ..? 모르겠다
        thirdDicecheck(player1, player2); // 일단 호출
    }

    // ★ --> 여기부터 다시 풀어보기
    public void thirdDicecheck(DicePlayer target, DicePlayer attacker){
        int attackerTotalScore = 0; // 공격하는 사람의 총 점수
        int targetTotalScore = 0; // 공격 당하는 사람의 총 점수

        final int STEAL = 1;
        final int BUFF = 3;
        final int DEATH = 4;

        // 플레이어 1과 플레이어 2의 세번째 숫자 게임 (근데 여기는 플레이어 1만 있음 .. )
        if(diceArray1[DICE_MAX_NUM-1] == STEAL){
            attackerTotalScore = attacker.totalScoreNumber();
            attackerTotalScore += 3;

            targetTotalScore = target.totalScoreNumber();
            targetTotalScore -= 3;
        }

        if(diceArray1[DICE_MAX_NUM-1] == BUFF){
            attackerTotalScore = attacker.totalScoreNumber();
            attackerTotalScore += 2;
        }

        if(diceArray1[DICE_MAX_NUM-1] == DEATH){
            attackerTotalScore = attacker.totalScoreNumber();
            attackerTotalScore = -777;
        }
    }

    public String winner() {
        return player1.getName(); // 임시
    }

    // ★ --> 여기까지 다시 풀어야 하는 부분

    @Override
    public String toString() {
        return "DiceGame{" +
                "diceArray1=" + Arrays.toString(diceArray1) +
                ", totalScore1= " + totalScore1 +
                ",\n\t\t diceArray2=" + Arrays.toString(diceArray2) +
                ", totalScore2= " + totalScore2 +
                '}';
    }
}
