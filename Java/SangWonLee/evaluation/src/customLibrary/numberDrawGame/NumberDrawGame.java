package customLibrary.numberDrawGame;

import customLibrary.utility.random.CustomRandom;

import java.util.Scanner;

public class NumberDrawGame {
    private final int MIN = 3;
    private final int MAX = 33;

    final private int winningNumber;
    final private Scanner scanner;

    public NumberDrawGame() {
        this.winningNumber = CustomRandom.generateNumber(MIN, MAX);
        System.out.println("정답: " + winningNumber);

        scanner = new Scanner(System.in);
    }

    public void play() {
        System.out.println("게임을 시작합니다!");

        final int CHANCE = 7;
        for (int i = 0; i < CHANCE; i++) {
            System.out.print("3 ~ 33 사이의 숫자를 입력하세요: ");
            int userInputNumber = scanner.nextInt();

            if (userInputNumber == winningNumber) {
                System.out.println("승리하였습니다!");
                System.out.println();
                return;
            } else {
                System.out.printf("기회를 1회 소비하였습니다 (남은 턴: %d)\n", CHANCE - (i + 1));
            }
        }

        System.out.println("기회를 모두 소비하였습니다 (패배!)");
    }
}
