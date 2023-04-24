package problems.prob4;

import customLibrary.utility.sequence.NumberSequence;

public class Problem4 {
    public static void main(String[] args) {
        final int START = 54;
        final int END = 132;

        final NumberSequence sequence = new NumberSequence(START, END);
        sequence.addThroughout();

        System.out.println(sequence.getTotalSum());
    }
}
