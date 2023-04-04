package test.test02;

import java.util.List;

public class Test02 {
    public static void main(String[] args) {
        final int START = 1;
        final int END = 100;
        final int EVEN_DECISION = 2;

        NumberSequence numberSequence = new NumberSequence(START,END);

        final List<Integer> foundNumberSequence =
                numberSequence.findConditionMatchNumber(EVEN_DECISION);

        System.out.println("1~100까지의 짝수:" + foundNumberSequence);

        final int THREE_TIMES_DECISION = 3;
        final List<Integer> foundNumberSequence2 =
                numberSequence.findConditionMatchNumber(THREE_TIMES_DECISION);

        System.out.println("1~100까지의 3의 배수: " + foundNumberSequence2);
        final int FOUR_TIMES_DECISION = 4;

        final List<Integer> foundNumberSequence3 =
                numberSequence.findConditionMatchNumber(FOUR_TIMES_DECISION);

        System.out.println("1~100까지의 4의 배수: " + foundNumberSequence3);

        final int foundNumberSequence4 =
                numberSequence.findConditionAndSumNumber(FOUR_TIMES_DECISION);

        System.out.println("1~100까지의 4의 배수 총합: "+foundNumberSequence4);
    }
}
