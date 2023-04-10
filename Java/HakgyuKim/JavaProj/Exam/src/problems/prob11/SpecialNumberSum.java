package problems.prob11;

import customLibrary.CustomSum;

public class SpecialNumberSum {
    final private int NUMBER_START = 50;
    final private int NUMBER_END = 100;
    final private int DECISION_NUMBER = 2;
    final private int numberSum = CustomSum.getSpecialSum(NUMBER_START, NUMBER_END, DECISION_NUMBER);

    public void getSpecialNumberSum() {
        System.out.println(numberSum);
    }
}
