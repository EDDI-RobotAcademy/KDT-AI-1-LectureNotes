package problems.prob11;

public class Twice {

    final private int MIN_NUMBER = 50;
    final private int MAX_NUMBER = 100;
    final private int TWICE_DECISION_NUMBER = 2;

    public void TwiceSum() {
        int twiceSum = 0;

        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            if (i % TWICE_DECISION_NUMBER == 0) {
                twiceSum += i;
            }
        }

        System.out.println(twiceSum);
    }
}
