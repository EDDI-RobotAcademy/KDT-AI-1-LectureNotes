package practice.numProb;

import java.util.ArrayList;
import java.util.List;

// 1. 1 ~ 100까지 숫자중 짝수만 출력해보자.
// 2. 1 ~ 100까지 숫자중 3의 배수만 출력해보자!
// 3. 1 ~ 100까지 숫자중 4의 배수를 더한 결과를 출력해보자!
public class NumberList {

    final private int START = 1;
    final private int END = 100;
    final private int EVEN_DECISION = 2;
    final private List<Integer> evenArray = new ArrayList<>();
    final private int THIRD_TIMES_DECISION = 3;
    final private List<Integer> thirdTimesArray = new ArrayList<>();
    private int fourthTimesSum = 0;

    // 숫자 출력하도록 - for 문
    public NumberList() {
        for (int numberIdx = START; numberIdx <= END; numberIdx++) {

            // 짝수만
            if (numberIdx % EVEN_DECISION == 0) {
                evenArray.add(numberIdx);
            }
            // 3의 배수만
            if (numberIdx % THIRD_TIMES_DECISION == 0) {
                thirdTimesArray.add(numberIdx);
            }

            final  int FOURTH_TIMES_DECISION = 4;
            final List<Integer> fourthTimesArray = new ArrayList<>();

            if (numberIdx % FOURTH_TIMES_DECISION == 0) {
                fourthTimesArray.add(numberIdx);
//                fourthTimesSum += fourthTimesArray.get(numberIdx);
                fourthTimesSum += numberIdx;
                // 이미 if 조건에 의해 numberIdx에 4의 배수가 뽑힌 상태인거라 저거만 더해줘도 됨!
            }
        }
    }

    @Override
    public String toString() {
        return "NumberList{" +
                "evenArray=" + evenArray + '\n' +
                ", thirdTimesArray=" + thirdTimesArray + '\n' +
                ", fourthTimesSum=" + fourthTimesSum +
                '}';
    }
}

