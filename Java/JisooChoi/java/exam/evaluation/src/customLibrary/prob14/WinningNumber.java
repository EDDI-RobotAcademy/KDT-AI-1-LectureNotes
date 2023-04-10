package customLibrary.prob14;

import java.util.Scanner;

public class WinningNumber {
    private int randomWinnerNum;
    private int count = 1;

    public WinningNumber(){
        final int RANDOM_MAX_NUM = 7;
        final int CONDITION_MAX = 33;
        final int CONDITION_MIN = 3;

        for(int i = 0; i < RANDOM_MAX_NUM; i++){
            randomWinnerNum = (int)(Math.random() * CONDITION_MAX) + CONDITION_MIN;

            System.out.println("3 ~ 33중 숫자를 기입해주세요 > ");
            System.out.printf("현재 라운드 (%d)\n", count);
            Scanner scan = new Scanner(System.in);
            int inputNum = scan.nextInt();

            if(randomWinnerNum == inputNum){
                System.out.println("승리 !");
            }
            count++;

            if(i == RANDOM_MAX_NUM-1){
                System.out.println("7번의 기회를 모두 소진하여 패배하였습니다.");
            }
        }
    }


}
