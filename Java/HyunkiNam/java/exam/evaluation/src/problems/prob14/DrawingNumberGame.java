package problems.prob14;

import customLibrary.CustomRandom;

import java.util.Scanner;

public class DrawingNumberGame {

    public void playGame(){
        final int MIN_NUMBER = 3;
        final int MAX_NUMBER = 33;
        final int correctNumber = CustomRandom.generateNumber(MIN_NUMBER, MAX_NUMBER);
        int chance = 7;

        System.out.println("당첨 번호 : " + correctNumber);

        while(true){
            if(chance > 0){
                System.out.println(chance + "번 남았습니다.");
            }

            if(chance == 0) {
                System.out.println("7번의 기회를 소진해 패배... 당첨 번호는 " + correctNumber + "입니다.");
                break;
            }

            Scanner sc = new Scanner(System.in);
            int selectNumber = sc.nextInt();
            chance--;

            if(correctNumber == selectNumber){
                System.out.println("승리!!! 당첨 번호 : " + correctNumber + " / 입력한 번호 : " + selectNumber);
                break;
            }
        }
    }
}
