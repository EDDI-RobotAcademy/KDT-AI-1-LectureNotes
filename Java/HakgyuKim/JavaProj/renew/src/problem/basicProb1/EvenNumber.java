package problem.basicProb1;

public class EvenNumber {
    public static void main(String[] args) {
        final int MAX = 101;
        final int EVEN_DECISION = 2;
        final int DECISION_MAKER = 0;
        for (int i = 1; i < MAX; i++) {
            if (i % EVEN_DECISION == DECISION_MAKER) {
                System.out.println(i);
            }
        }
    }
}
