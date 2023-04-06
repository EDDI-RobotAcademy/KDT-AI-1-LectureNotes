package problem.first.nonClass;

public class FirstProb2 {
    public static void main(String[] args) {
        final int START = 1;
        final int END = 100;
        final int THREE_TIMES_DECISION = 3;
        final int NO_REMAIN = 0;

        for (int i = START; i <= END; i++) {
            if (i % THREE_TIMES_DECISION == NO_REMAIN) {
                System.out.println("3의 배수만 출력: " + i);
            }
        }
    }
}
