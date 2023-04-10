package problems.prob12.q2randomNumGame;

import customLibrary.Random;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    final static int MIN_NUM = 3;
    final static int MAX_NUM = 33;
    final static int CHANCE = 7;

    public Game() {
       final int randomWinNumber = Random.randomNumber(MIN_NUM, MAX_NUM);
        ArrayList<Integer> playerInputNumList = new ArrayList<>();

        // 당첨번호가 맞거나 7번의 기회를 다 쓰면 게임종료
        boolean gameContinue = true;

        for(;gameContinue;) {
            if(playerInputNumList.size() == CHANCE){
                System.out.println("기회가 끝났습니다. 당첨번호는 " +randomWinNumber+ "입니다.");
                gameContinue = false;
            }

            Scanner scan = new Scanner(System.in);
            System.out.println("숫자를 입력하세요.");
            int playerInputNum = scan.nextInt();

            if (playerInputNum == randomWinNumber) {
                System.out.println("당첨 번호는" + randomWinNumber + " 입니다. 승리입니다.");
                gameContinue = false;
            } else {
                System.out.println("당첨 번호가 아닙니다.");
                playerInputNumList.add(playerInputNum);
            }
        }
    }
}
