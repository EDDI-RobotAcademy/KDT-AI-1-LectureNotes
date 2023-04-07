package problems.prob15;

import java.util.ArrayList;
import java.util.List;

// 1,3,4,5,9,11,13,... 수열의 273번째 값 구하기
// 일단 포문 돌리자
public class FindSequence {
    final private int START = 1;
    final private int TEMPORARY_END = 1000;
    final private int PLUS_NUMBER = 2;
    final private List<Integer> sequenceList = new ArrayList<>();
    final private int HAVE_TO_FIND_NUMBER = 273;
    final private int LIST_BIAS = 1;

    public void makeSequence() {

        for (int i = START; i < TEMPORARY_END; i += PLUS_NUMBER) {
            sequenceList.add(i);
        }
        System.out.println(sequenceList);
    }

    public void find273RdNumber() {
        System.out.println("273번째 값은: " + sequenceList.get(HAVE_TO_FIND_NUMBER-LIST_BIAS));
    }
}
