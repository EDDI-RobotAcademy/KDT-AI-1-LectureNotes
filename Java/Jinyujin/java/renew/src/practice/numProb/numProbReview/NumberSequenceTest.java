package practice.numProb.numProbReview;

import java.util.List;

// 1. 1 ~ 100까지 숫자중 짝수만 출력해보자.
// 2. 1 ~ 100까지 숫자중 3의 배수만 출력해보자!
// 3. 1 ~ 100까지 숫자중 4의 배수를 더한 결과를 출력해보자!
public class NumberSequenceTest {

    public static void main(String[] args) {
        final int START = 1;
        final int END = 100;
        final int EVEN_DECISION = 2;
        final int THIRD_TIMES_DECISION = 3;
        final int FOURTH_TIMES_DECISION = 4;

        NumberSequence numberSequence = new NumberSequence(START, END);

        // 짝수
        final List<Integer> foundEvenSequence =
                numberSequence.findConditionMatchNumber(EVEN_DECISION);

        System.out.println("짝수 > " + foundEvenSequence);

        // 3의 배수
        final List<Integer> foundThirdTimesSequence =
                numberSequence.findConditionMatchNumber(THIRD_TIMES_DECISION);

        System.out.println("3의 배수 > " + foundThirdTimesSequence);

        // 4의 배수 합계
        int foundFourthTimesSum = numberSequence.findConditionMatchSum(FOURTH_TIMES_DECISION);
        System.out.println("4의 배수의 합 > " + foundFourthTimesSum);
    }
}
