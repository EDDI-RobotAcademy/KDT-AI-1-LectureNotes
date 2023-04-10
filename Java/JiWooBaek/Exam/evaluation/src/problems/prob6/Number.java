package problems.prob6;

// 6번 문제입니다.

public class Number {
    public static void main(String[] args) {
        final int START = 50;
        final int END = 100;
        final int FIVE_TIMES_DECISION = 5;
        final int NO_REMAIN = 0;

        for (int i = START; i <= END; i++) {
            if (i % FIVE_TIMES_DECISION == NO_REMAIN) {
                System.out.println("5의 배수만 출력: " + i);
            }
        }
    }
}


