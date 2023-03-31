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

    int totalScore;

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
            //(1) 각 점수를 플레이어 객체가 점수 객체에게 전달해서 반환 값을 줘 !
            totalScore = player1.addScore(diceArray1[i]);

            if(diceArray1[FIRST_CHECK_NUMBER] % CONDITION_NUM == ODD){
                break;
            }
        }

        //플레이어 2
        for(int i = 0; i < DICE_MAX_NUM; i++){
            diceArray2[i] = player2.rollDice(i);

            // 총 합계
            totalScore = player2.addScore(diceArray2[i]);

            if(diceArray2[FIRST_CHECK_NUMBER] % CONDITION_NUM == ODD){
                break;
            }
        }

        System.out.println("player: "+player1);
        System.out.println("player: "+player2);

        // 이렇게 되면 어떤 기준으로 표적이 되고, 공격자가 되는지 ..? 모르겠다
        thirdDicecheck(player1, player2); // 일단 호출
    }

    // ★ --> 여기부터 다시 풀어보기
    public void thirdDicecheck(DicePlayer target, DicePlayer attacker){

    }

    public String winner() {
        return player1.getName(); // 임시
    }

    // ★ --> 여기까지 다시 풀어야 하는 부분

}
