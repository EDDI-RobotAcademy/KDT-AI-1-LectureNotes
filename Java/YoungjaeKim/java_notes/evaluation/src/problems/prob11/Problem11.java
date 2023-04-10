package problems.prob11;

public class Problem11 {
    public static void main (String[] args) {
        final int START = 50;
        final int END = 100;
        int sum = 0;
        int count = 0;

        for (int i = START; i <= END; i++) {
            if (i % 2 == 0) {
                System.out.println("count = " + (++count) + ", 현재 숫자 : " + i);
                sum += i;
            }
        }

        // 검산
        System.out.println("(50 + 100) * 13 = " + (50 + 100) * 13);
        System.out.println("50부터 100까지 2의 배수의 합 : " + sum);
    }
}
