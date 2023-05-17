package problems.prob23;

import java.util.Scanner;

// 키보드 입력을 받아서 짝수인지 홀수인지 판정하는 프로그램을 만들어봅시다.
public class NumberCheck {
    Scanner scanner = new Scanner(System.in);
    private int checkNum;

    public NumberCheck() {
        System.out.println("숫자를 입력해주세요");
        checkNum = scanner.nextInt();
        if (checkNum % 2 == 0) {
            System.out.println("짝수입니다.");
        } else {
            System.out.println("홀수입니다.");
        }
    }
}
