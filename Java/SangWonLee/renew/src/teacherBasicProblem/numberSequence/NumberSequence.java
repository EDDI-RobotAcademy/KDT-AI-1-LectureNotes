package teacherBasicProblem.numberSequence;

import java.util.ArrayList;
import java.util.List;

public class NumberSequence {

    final int start;
    final int end;

    public NumberSequence(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public List<Integer> findConditionMatchNumber(int evenDecision) {
        List<Integer> tmpNumberList = new ArrayList<>();

        for (int i = start; i <= end; i++) {
            if (i % evenDecision == 0) {
                tmpNumberList.add(i);
            }
        }

        return tmpNumberList;
    }

    public int findConditionAndSumNumber(int fourTimesDecision) {
        int tmpSum = 0;

        for (int i = start; i <= end; i++) {
            if (i % fourTimesDecision == 0) {
                tmpSum += i;
            }
        }

        return tmpSum;
    }
}
