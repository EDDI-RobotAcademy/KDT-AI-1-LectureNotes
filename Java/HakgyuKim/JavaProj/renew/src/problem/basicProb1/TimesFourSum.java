package problem.basicProb1;

public class TimesFourSum {
    public static void main(String[] args) {
        final int MAX = 101;
        final int FOUR_DECISION = 4;
        final int DECISION_MAKER = 0;
        int numberSum = 0;
        for (int i = 1; i < MAX; i++) {
            if (i % FOUR_DECISION == DECISION_MAKER) {
                numberSum += i;
            }
        }
        System.out.println(numberSum);
    }
}
