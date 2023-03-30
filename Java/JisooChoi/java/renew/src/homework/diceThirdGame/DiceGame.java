package homework.diceThirdGame;

import java.util.Arrays;

public class DiceGame {
    DicePlayer player1 = new DicePlayer("Cat"); //게임을 하려면 사용자가 2명 필요함
    DicePlayer player2 = new DicePlayer("Dog");
    private int[] diceArray1;
    private int[] diceArray2;
    final int DICE_MAX_NUM = 3;
    DiceScore gameScore;
    int totalScore1 = 0;
    int totalScore2 = 0;

    public DiceGame(){
        diceArray1 = new int[DICE_MAX_NUM]; //주사위 3개를 넣을 배열 생성
        diceArray2 = new int[DICE_MAX_NUM]; //주사위 3개를 넣을 배열 생성
    }

    public void gamePlay() {
        // 1. 주사위를 던진다.
        //플레이어 1
        for(int i = 0; i < DICE_MAX_NUM; i++){
            diceArray1[i] = player1.rollDice(i);

            // 총 합계
            totalScore1 += diceArray1[i];

//            int diceNumberSum = diceArray1[i];
//            gameScore = new DiceScore(diceNumberSum);

            if(diceArray1[0] % 2 == 1){
                break;
            }
        }

        //플레이어 2
        for(int i = 0; i < DICE_MAX_NUM; i++){
            diceArray2[i] = player2.rollDice(i);

            // 총 합계
            totalScore2 += diceArray2[i];

            if(diceArray2[0] % 2 == 1){
                break;
            }
        }

        //thirdDicecheck();
    }

    // ★ --> 여기부터 다시 풀어보기
    public void thirdDicecheck(DicePlayer target, DicePlayer attack){
        // 플레이어 1과 플레이어 2의 세번째 숫자 게임
        if(diceArray1[DICE_MAX_NUM-1] == 1){

        }

        if(diceArray1[DICE_MAX_NUM-1] == 3){

        }

        if(diceArray1[DICE_MAX_NUM-1] == 4){

        }
    }

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
