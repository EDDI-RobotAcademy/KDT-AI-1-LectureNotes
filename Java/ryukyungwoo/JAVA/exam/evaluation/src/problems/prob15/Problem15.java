package problems.prob15;

import java.util.ArrayList;
import java.util.List;

/*

7. 아래와 같은 수열이 있습니다. 1, 3, 5, 7, 9, 11, 13, … 이 수열의 273번째 값을 프로그램으로 작성하여 구해보세요.
 */
class SequenceNumberPlusTwo {
    final private int START = 1;
    final private int END = 1000;
    List<Integer> sequenceNumberPlusTwoList = new ArrayList<>();
    public SequenceNumberPlusTwo () {
        for (int i = START; i < END; i+=2) {
            sequenceNumberPlusTwoList.add(i);
        }
    }

    @Override
    public String toString() {
        return "SequenceNumberPlusTwo{" +
                "sequenceNumberPlusTwoList=" + sequenceNumberPlusTwoList +
                '}';
    }
}

public class Problem15 {
    public static void main(String[] args) {
        System.out.println(new SequenceNumberPlusTwo().sequenceNumberPlusTwoList);
        System.out.println(new SequenceNumberPlusTwo().sequenceNumberPlusTwoList.get(273));
    }
}
