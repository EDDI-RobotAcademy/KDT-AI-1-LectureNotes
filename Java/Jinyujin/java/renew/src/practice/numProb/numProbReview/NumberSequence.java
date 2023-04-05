package practice.numProb.numProbReview;

import java.util.ArrayList;
import java.util.List;

public class NumberSequence {

    int start;
    int end;

    public NumberSequence(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public List<Integer> findConditionMatchNumber(int decisionNumber) {
        List<Integer> tmpNumberList = new ArrayList<>();

        for (int i = start; i <= end; i++) {
            if (i % decisionNumber == 0) {
                tmpNumberList.add(i);
            }
        }

        return tmpNumberList;
    }

    public int findConditionMatchSum(int decisionNumber) {
        int tmpSum = 0;

        for (int i = start; i <= end; i++) {
            if (i % decisionNumber == 0)
            tmpSum += i;
        }
        return tmpSum;
    }
}
