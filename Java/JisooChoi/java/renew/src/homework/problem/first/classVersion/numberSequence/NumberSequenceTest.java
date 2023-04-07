package homework.problem.first.classVersion.numberSequence;

import java.util.List;

public class NumberSequenceTest {
    public static void main(String[] args) {
        final int START = 1;
        final int END = 100;
        final int EVEN_DECISION = 2;

        NumberSequence numberSequence = new NumberSequence(START, END); // 객체 생성

        // 1 ~ 100까지의 짝수를 받아왔다. (뒤의 결과의 반환값이 List<Integer>이기 때문에 받아 올 수 있다.)
        final List<Integer> foundNumberSequence = numberSequence.findConditionMatchNumber(EVEN_DECISION);
        System.out.println("찾은 결과: "+foundNumberSequence);

        // 1 ~ 100까지의 3의 배수를 받아왔다.
        final int THREE_TIMES_DECISION = 3;
        final List<Integer> foundNumberSequence2 = numberSequence.findConditionMatchNumber(THREE_TIMES_DECISION);
        System.out.println("찾은 결과: "+foundNumberSequence2);

        final int FOUR_TIMES_DECISION = 4;
        final int foundNumberSequenceSum = numberSequence.findConditionAndSumNumber(FOUR_TIMES_DECISION);
        System.out.println("합산 결과: "+foundNumberSequenceSum);
    }
}
