package problems.prob6;

public class PrintFifthTimesNumber {
    final private int MIN_NUMBER = 50;
    final private int MAX_NUMBER = 50;
    final private int FIFTH_TIMES_DECISION = 5;

    public void getFifthTimesNumber() {
        for (int i = 50; i <= 100; i++) {

            if (i % 5 == 0) {
                System.out.println(i);
            }
        }
    }
}
