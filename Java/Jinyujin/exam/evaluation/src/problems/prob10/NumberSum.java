package problems.prob10;

public class NumberSum {

    final private int MIN_NUMBER = 50;
    final private int MAX_NUMBER = 100;

    public void calculateSum() {
        int numberSum = 0;

        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            numberSum += i;
        }

        System.out.println(numberSum);
    }
}
