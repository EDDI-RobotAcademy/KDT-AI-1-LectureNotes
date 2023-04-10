package problems.prob10;

import customLibrary.math.SumCalculator;

public class Problem10 {
    public static void main(String[] args) {
        final int START = 50;
        final int END = 100;
        SumCalculator sumCalculator = new SumCalculator();
        System.out.println(sumCalculator.summation(START, END));
    }
}
