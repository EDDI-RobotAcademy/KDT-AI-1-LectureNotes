package problems.prob23;

import java.util.Scanner;

public class NumberDefiner {
    final private int DECISION_MAKER = 2;
    final private int DECISION_ODD = 1;
    final private int DECISION_EVEN = 0;

    public void defineNum() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("숫자를 입력하세요.");
        int targetNum = scanner.nextInt();

        if (targetNum % DECISION_MAKER == DECISION_EVEN) {
            System.out.println("짝수 입니다.");
        } else if (targetNum % DECISION_MAKER == DECISION_ODD) {
            System.out.println("홀수 입니다.");
        }
    }
}
