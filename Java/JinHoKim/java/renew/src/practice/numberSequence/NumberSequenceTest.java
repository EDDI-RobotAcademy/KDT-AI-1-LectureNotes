package practice.numberSequence;

import java.util.List;

public class NumberSequenceTest {
    public static void main(String[] args) {
        final int START = 1;
        final int END = 100;
        final int EVEN_DECISION = 2;

        NumberSequence numberSequence = new NumberSequence(START, END);

        final List<Integer> foundNumberSequence = numberSequence.findConditionMatchNumber(EVEN_DECISION);
        System.out.println(foundNumberSequence);

        final int THREE_TIMES_DECISION = 3;
        final List<Integer> foundNumberSequence2 = numberSequence.findConditionMatchNumber(THREE_TIMES_DECISION);
        System.out.println(foundNumberSequence2);

        final int FOUR_TIMES_DECISION = 4;
        final int foundNumberSequenceSequenceSum = numberSequence.findConditionAndSumNumber(FOUR_TIMES_DECISION);
        System.out.println(foundNumberSequenceSequenceSum);

    }
}
