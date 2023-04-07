package basic.classVersion.numberSequence;

import java.util.List;

public class NumberSequenceTest {
    public static void main(String[] args) {
        final int START = 1;
        final int END = 100;
        final int EVEN_DECISION = 2;

        NumberSequence numberSequence = new NumberSequence(START,END);
        final List<Integer> foundNumberSequence = numberSequence.findConditionMatchNumber(EVEN_DECISION);

        //basic1
        System.out.println("찾은 결과: " + foundNumberSequence);

        //basic2
        final int THREE_EVEN_DECISION = 3;
        final List<Integer> foundNumberSequence2 = numberSequence.findConditionMatchNumber(THREE_EVEN_DECISION);
        System.out.println("찾은 결과: " + foundNumberSequence2);

        //basic3

        final int FOUR_EVEN_DECISION = 4;
        final List<Integer> foundNumberSequence3 = numberSequence.findConditionMatchNumber(FOUR_EVEN_DECISION);
        final int foundSum = numberSequence.fineConditionAndSumNumber(FOUR_EVEN_DECISION);

        System.out.println("찾은 결과: " + foundNumberSequence3);
        System.out.println("4의 배수 총합: " + foundSum);


    }
}
