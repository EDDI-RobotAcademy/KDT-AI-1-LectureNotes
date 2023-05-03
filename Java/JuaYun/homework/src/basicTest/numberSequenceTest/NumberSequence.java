package basicTest.numberSequenceTest;


import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class NumberSequence {
    final int start;
    final int end;

    public NumberSequence(int start, int end) {
        this.start = start;
        this.end = end;
    }
    public List<Integer> findMatchNumber(int evenDecision) {
        List<Integer> tmpNumberList = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            if (i % evenDecision == 0) {
                tmpNumberList.add(i);
            }
        }
        return tmpNumberList;
    }
    public int findMatchNumberSum(int fourDecision) {
        int tmpSum = 0;

        for (int i = start; i <= end; i++) {
            if (i % fourDecision == 0) {
                tmpSum += i;
            }
        }
        return tmpSum;
    }
}
