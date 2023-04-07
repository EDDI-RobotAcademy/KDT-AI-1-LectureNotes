package problems.prob11;

public class Problem11 {
    public static void main(String[] args) {
        int MAX = 100;
        int MIN = 50;
        int DECISION = 2;
        int NumberSum = 0;

        for (int i = MIN; i <= MAX; i++) {
            if (i % DECISION == 0)
                NumberSum += i;
        }
        System.out.println(NumberSum);
    }
}
