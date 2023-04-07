package problems.prob11;

import customLibrary.math.SumCalculator;

public class Problem11 {
    public static void main(String[] args) {
        final int START = 50;
        final int END = 100;
        final int DIVIDER = 2;
        final int modifiedStart = (START%DIVIDER==0)?START/DIVIDER:START/DIVIDER+1;
        SumCalculator sumCalculator = new SumCalculator();
        System.out.println(sumCalculator.summation(modifiedStart, (int) (END/DIVIDER))*DIVIDER);
    }
}
