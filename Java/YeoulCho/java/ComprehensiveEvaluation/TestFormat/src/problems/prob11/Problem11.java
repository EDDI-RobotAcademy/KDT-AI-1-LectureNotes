package problems.prob11;

public class Problem11 {
    public static void main(String[] args) {
        final int START = 50;
        final int END = 100;
        int Sum = 0;
        for (int i = START; i <= END; i++) {
            if (i % 2 == 0) {
                Sum += i;
            }
        }
        System.out.println(Sum);
    }
}
