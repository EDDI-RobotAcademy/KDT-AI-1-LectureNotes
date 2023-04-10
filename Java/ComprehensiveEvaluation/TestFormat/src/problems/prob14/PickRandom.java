package problems.prob14;

import customLibrary.CustomRandom;

import java.util.Scanner;

public class PickRandom {
    private int ranNumber;
    private final int MIN = 3;
    private final int MAX = 33;
    private int choiceNumber;
    private boolean checkWin = false;

    public PickRandom() {
        ranNumber = CustomRandom.generateNumber(MIN, MAX);
        System.out.println("숫자가 정해졌습니다 3~33사이의 숫자 중 하나를 고르시오");
    }

    public void setChoiceNumber() {
        Scanner scanner = new Scanner(System.in);
        choiceNumber = scanner.nextInt();
    }

    public void isCheckWin() {
        if(choiceNumber == ranNumber) {
            System.out.println(" 승리하셨습니다 ");
        } else {
            for (int i = 0; i < 6; i++) {
                System.out.println(" 한번 더 고르십시오");
                setChoiceNumber();
                if (choiceNumber == ranNumber) {
                    System.out.println("승리하셨습니다");
                    break;
                }
            }
            System.out.println(" 당신은 패배하셨습니다" );
        }
    }
}
