package problem.first.nonClass;

public class FirstProb3 {
    public static void main(String[] args) {
        final int START = 1;
        final int END = 100;
        final int FOUR_TIMES_DECISION = 4;
        final int NO_REMAIN = 0;

        int sumNumber = 0;
        int count = 0;

        for (int i = START; i <= END; i++) {
            if (i % FOUR_TIMES_DECISION == NO_REMAIN) {
                System.out.println("count = " + (++count) + ", 4의 배수만 출력: " + i);
                sumNumber += i;
            }
        }

        System.out.println("1 ~ 100까지 4의 배수들의 총합: " + sumNumber);
        System.out.println("104 * 12 = " + 104 * 12);
        System.out.println("104 * 12 + 52 = " + (104 * 12 + 52));
    }
}
