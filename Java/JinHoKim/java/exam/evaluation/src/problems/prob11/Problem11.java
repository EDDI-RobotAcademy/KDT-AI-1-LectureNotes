package problems.prob11;

import customLibrary.utility.sequence.NumberSequence;

public class Problem11 {
    public static void main(String[] args) {
        final int START = 50;
        final int END = 100;

        final int TIMES_OF_WANT = 2;
        final NumberSequence sequence = new NumberSequence(START, END);
        sequence.addThroughoutWithCondition(TIMES_OF_WANT);

        System.out.println(sequence.getTotalSum());
    }
}
