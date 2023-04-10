package customLibrary.utility.classProb14;

import customLibrary.utility.CustomRandom;

import java.util.Scanner;

public class LottoGameManager {
    final int MIN = 3;
    final int MAX = 33;
    private int winNumber;
    private int selectedNumber;
    int life = 6;
    boolean isGameProgress = true;
    final private Scanner scan = new Scanner(System.in);

    private int generateWinNum () {
        int winNum = CustomRandom.generateNumber(MIN, MAX);
        return winNum;
    }

    public void LottoGameManager() {
        System.out.println("게임시작!");
        winNumber = generateWinNum();

        while (isGameProgress) {
            System.out.println("행운의 번호를 입력해주세요!");
            selectedNumber = scan.nextInt();
            if (winNumber == selectedNumber) {
                System.out.println("승리");
                break;
            }
            else if (MIN <= selectedNumber && selectedNumber <= MAX) {
                System.out.println("행운의 숫자가 아닙니다!");
                System.out.printf("남은 기회: %d번\n", life);
                life--;
                if (life < 0) {
                    System.out.println("패배");
                    break;
                }
            }
            else {
                System.out.println("올바른 숫자를 입력해주세요");
            }
        }
    }
}
