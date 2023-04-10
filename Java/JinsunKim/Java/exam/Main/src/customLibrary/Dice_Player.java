package customLibrary;
import java.util.Arrays;
//총 10명의 플레이어가
// 주사위를 굴리는데
// 인덱스 짝수가 홀수가 나오면 차감
// 인덱스 홀수가 짝수가 나오면 차감

public class Dice_Player {
    final int PLAYER_NUM = 10;
    final int DICE_ROLL = 10;

    final Dice[] diceNumber = new Dice[DICE_ROLL];
    final int [] playerArr = new int[PLAYER_NUM];
    final int EVEN = 2;
    final int onePoint = -1;

    public Dice_Player() {

            for (int i = 0; i < PLAYER_NUM; i++) {  // 플레이어 생성
                playerArr[i] = i + 1;
                int sum = 0;

                for (int j = 0; j <DICE_ROLL; j++) {  // 주사위 돌리기
                    diceNumber[j] = new Dice();
                    int score = diceNumber[j].getDiceNumber();
                    if ((playerArr[i] % EVEN == 0) && (score % EVEN != 0 ) // 플레이어가 짝수면서 주사위가 홀수면 -1차감
                            || (playerArr[i] % EVEN != 0) && (score % EVEN == 0 ) ) // 플레이어가 홀수면서 주사위가 홀수면 -1차감

                    {score += onePoint;}
                    sum += score;
                }
                System.out.println("플레이어 " + playerArr[i] + " 의 주사위 합은 " + sum);
            }
    }





}
