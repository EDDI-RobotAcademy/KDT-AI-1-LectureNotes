package problems.prob10;

import customLibrary.utility.sequence.NumberSequence;

public class Problem10 {
    public static void main(String[] args) {
        final int START = 50;
        final int END = 100;

        final NumberSequence sequence = new NumberSequence(START, END);
        sequence.addThroughout();

        System.out.println(sequence.getTotalSum());
    }
}
