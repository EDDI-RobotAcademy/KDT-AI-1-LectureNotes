package problems.prob14;

import customLibrary.CustomRandom;

import java.util.Scanner;

public class NumberMatchGame {
    final private int START = 3;
    final private int END = 33;
    final private int TURN_MAX = 7;
    final private int winningNum = CustomRandom.generateNumber(START, END);

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < TURN_MAX; i++) {
            System.out.println((i + 1) + "번 턴 " + START + " ~ " + END
                                + " 사이의 숫자를 입력하세요");
            int numSelect = scanner.nextInt();
            if (numSelect == winningNum) {
                System.out.println("정답: " + winningNum + "을 맞췄습니다! \n 게임에 승리하셨습니다!");
                break;
            } else if (i == (TURN_MAX -1)) {
                System.out.println(numSelect + "은 정답이 아닙니다!");
                System.out.println("정답을 맞추지 못했습니다" + '\n' +
                        "정답은 " + winningNum + "이였습니다.");
            } else {
                System.out.println(numSelect + "은 정답이 아닙니다!");
            }
        }

    }


}
