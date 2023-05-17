package basicTest.numberSequenceTest;

import java.util.List;

public class NumberSequenceTest {
    public static void main(String[] args) {
        final int START = 1;
        final int END =100;
        final int EVEN_DECISION = 2;

        NumberSequence numberSequence = new NumberSequence(START,END);

        final List<Integer> foundNumberSequence1 = numberSequence.findMatchNumber(EVEN_DECISION);
        System.out.println(foundNumberSequence1);

        final int THREE_DECISION = 3;
        final List<Integer> foundNumberSequence2 = numberSequence.findMatchNumber(THREE_DECISION);
        System.out.println(foundNumberSequence2);

        final int FOUR_DECISION = 4;
        final int foundNumberSum = numberSequence.findMatchNumberSum(FOUR_DECISION);
        System.out.println(foundNumberSum);

    }
}
