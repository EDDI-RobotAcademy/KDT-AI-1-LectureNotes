package customLibrary.prob14;

import customLibrary.utility.CustomRandom;

import java.util.Scanner;

public class RandomPick {
    final int MIN = 3;
    final int MAX = 33;
    final int randomPick;
    final int life = 7; //기회 7번


    public RandomPick() {
        this.randomPick = CustomRandom.generateNumber(MIN, MAX);

    }

    public void play() {
        Scanner sc = new Scanner(System.in);
        int i = 1;
        while (i <= life) {
            System.out.print("3 ~ 33 까지의 숫자중 하나를 입력하시오: ");
            int inputNum = sc.nextInt();
            if (inputNum == randomPick) {
                System.out.print("당첨번호는: " + randomPick + "이며 승리하였습니다");
                break;
            }

            if (i == life) {
                System.out.println("자동 패배하였습니다. 당첨번호는: " + randomPick );
                break;
            }
            i++;
        }


    }
}
