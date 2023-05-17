package problem.first.nonClass;

public class FirstProb1 {
    public static void main(String[] args) {
        // 1 ~ 100까지 숫자중 짝수
        final int START = 1;
        final int END = 100;
        final int EVEN_DECISION = 2;
        final int EVEN = 0;

        for (int i = START; i <= END; i++) {
            if (i % EVEN_DECISION == EVEN) {
                System.out.println("짝수만 출력: " + i);
            }
        }
    }
}
