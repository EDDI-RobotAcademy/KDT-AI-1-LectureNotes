package problems.prob23;

import java.util.Scanner;

public class CheckNumber {
    Scanner scanner = new Scanner(System.in);
    private int number;

    public CheckNumber() {
        System.out.println("번호를 입력하시오");
        number = scanner.nextInt();
    }

    public void checkNum() {
        if (number % 2 == 0) {
            System.out.println("짝수입니다!");
        }else {
            System.out.println("홀수입니다!");
        }

    }
}
