package problems.prob6;

import customLibrary.utility.sequence.NumberSequence;

public class Problem6 {
    public static void main(String[] args) {
        final int START = 50;
        final int END = 100;

        final NumberSequence sequence = new NumberSequence(START, END);

        final int WANT_TO_FIND = 5;
        sequence.findTimesOf(WANT_TO_FIND);
    }
}
