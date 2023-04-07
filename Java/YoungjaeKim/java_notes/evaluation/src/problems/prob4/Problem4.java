package problems.prob4;

public class Problem4 {
    public static void main (String[] args) {
        final int START = 54;
        final int END = 132;
        int sum = 0;
        int count = 0;

        for (int i = START; i <= END; i++) {
            System.out.println("count = " + (++count) + ", 현재 숫자 : " + i);
            sum += i;
        }

        // 검산
        System.out.println("(54 + 132) * 39 = " + (54 + 132) * 39);
        System.out.println("7254 + 40번째 숫자(93) = " + (7254 + 93));
        System.out.println("54부터 132까지의 합 : " + sum);
    }
}
