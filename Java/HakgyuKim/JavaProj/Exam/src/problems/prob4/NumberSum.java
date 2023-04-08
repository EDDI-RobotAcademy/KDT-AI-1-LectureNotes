package problems.prob4;

import customLibrary.CustomSum;

public class NumberSum {
    final private int NUMBER_START = 54;
    final private int NUMBER_END = 132;
    final private int numberSum = CustomSum.getSum(NUMBER_START, NUMBER_END);

    public void getNumberSum() {
        System.out.println(numberSum);
    }
}
