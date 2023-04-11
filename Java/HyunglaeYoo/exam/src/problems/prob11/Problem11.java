package problems.prob11;

import customLibrary.NumberSequence;

import java.util.List;

public class Problem11 {
    public static void main(String[] args) {

        final int START = 50;
        final int END = 100;

        NumberSequence numberSequence = new NumberSequence(START, END);

        final int even = 2;

        final int foundNumberSequenceSum = numberSequence.findConditionAndSumNumber(even);

        System.out.println("합산 결과: " + foundNumberSequenceSum);

    }
}
