package problems.prob10;

import customLibrary.NumberSequence;

import java.util.List;

public class Problem10 {
    public static void main(String[] args) {

        final int START = 50;
        final int END = 100;
        final int EVEN = 1;

        NumberSequence numberSequence = new NumberSequence(START, END);

        final int foundNumberSequenceSum = numberSequence.findConditionAndSumNumber(EVEN);

        System.out.println("합산 결과: " + foundNumberSequenceSum);

    }
}
