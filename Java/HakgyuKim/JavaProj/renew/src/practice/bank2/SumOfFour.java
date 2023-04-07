package practice.bank2;

public class SumOfFour {
    public static void main(String[] args) {
        final int START = 1;
        final int END = 101;
        final int DECISION_NUMBER = 4;
        final int DECISION_MAKER = 0;
        int totalSum = 0;
        for (int i = START; i < END; i++) {
            if (i % DECISION_NUMBER == DECISION_MAKER) {
                totalSum += i;
            }
        }
        System.out.println(totalSum);
    }
}
