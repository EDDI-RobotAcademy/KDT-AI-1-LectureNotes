package problems.prob10;

import customLibrary.CustomSum;

public class NumberSum2 {
    final private int NUMBER_START = 50;
    final private int NUMBER_END = 100;
    final private int numberSum = CustomSum.getSum(NUMBER_START, NUMBER_END);

    public void getNumberSum() {
        System.out.println(numberSum);
    }
}
