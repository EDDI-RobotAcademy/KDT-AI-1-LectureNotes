package practice.bank2;

public class TimesThree {
    public static void main(String[] args) {
        final int START = 1;
        final int END = 101;
        final int DECISION_NUMBER = 3;
        final int DECISION_MAKER = 0;
        for (int i = START; i < END; i++) {
            if (i % DECISION_NUMBER == DECISION_MAKER) {
                System.out.println(i);
            } else {
                continue;
            }
        }
    }
}
