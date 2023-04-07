package problems.prob4;

import customLibrary.math.SumCalculator;

public class Problem4 {
    public static void main(String[] args) {
        final int START = 54;
        final int END = 132;
        SumCalculator sumCalculator = new SumCalculator();
        int result = sumCalculator.summation(START, END);
        System.out.println(result);
    }
}
