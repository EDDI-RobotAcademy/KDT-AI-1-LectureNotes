package problem.basicProb1;

public class TimesThree {
    public static void main(String[] args) {
        final int MAX = 101;
        final int THREE_DECISION = 3;
        final int DECISION_MAKER = 0;
        for (int i = 1; i < MAX; i++) {
            if (i % THREE_DECISION == DECISION_MAKER) {
                System.out.println(i);
            }
        }
    }
}
