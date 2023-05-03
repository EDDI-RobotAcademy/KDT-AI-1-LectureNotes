package examSolve.exam1.pro23;

import java.util.Scanner;

public class Pro23 {
    public static void main(String[] args) {
        final int DECISION_EVEN = 2;
        final int EVEN = 0;

        Scanner scan = new Scanner(System.in);
        System.out.print("숫자를 입력하세요: ");
        final int inputNumber = scan.nextInt();

        if (inputNumber % DECISION_EVEN == EVEN) {
            System.out.println("짝수입니다!");
        } else {
            System.out.println("홀수입니다!");
        }
    }
}
