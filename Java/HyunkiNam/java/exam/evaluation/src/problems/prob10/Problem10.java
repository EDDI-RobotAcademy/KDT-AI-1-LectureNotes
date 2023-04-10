package problems.prob10;

public class Problem10 {
    public static void main(String[] args) {
        final int MIN_NUMBER = 50;
        final int MAX_NUMBER = 100;
        int sum = 0;

        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            sum += i;
        }

        System.out.println(sum);
    }
}
