package problem.first.classVersion.numberSequence;

import java.util.List;

public class NumberSequenceTest {
    public static void main(String[] args) {
        final int START = 1;
        final int END = 100;
        final int EVEN_DECISION = 2;

        NumberSequence numberSequence = new NumberSequence(START, END);

        final List<Integer> foundNumberSequence = numberSequence.findConditionMatchNumber(EVEN_DECISION);

        // prob1 answer
        System.out.println("찾은 결과: " + foundNumberSequence);

        final int THREE_TIMES_DECISION = 3;
        final List<Integer> foundNumberSequence2 = numberSequence.findConditionMatchNumber(THREE_TIMES_DECISION);

        // prob2 answer
        System.out.println("찾은 결과: " + foundNumberSequence2);

        final int FOUR_TIMES_DECISION = 4;
        final int foundNumberSequenceSum = numberSequence.findConditionAndSumNumber(FOUR_TIMES_DECISION);

        // prob3 answer
        System.out.println("합산 결과: " + foundNumberSequenceSum);
    }
}
