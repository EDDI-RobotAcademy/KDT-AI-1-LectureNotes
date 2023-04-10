package problems.prob10;

public class Problem10 {
    public static void main (String[] args) {
        final int START = 50;
        final int END = 100;
        int sum = 0;
        int count = 0;

        for (int i = START; i <= END; i++) {
            System.out.println("count = " + (++count) + ", 현재 숫자 : " + i);
            sum += i;
        }

        // 검산
        System.out.println("(50 + 100) * 25 = " + (50 + 100) * 25);
        System.out.println("3750 + 26번째 숫자(75) = " + (3750 + 75));
        System.out.println("50부터 100까지의 합 : " + sum);
    }
}
