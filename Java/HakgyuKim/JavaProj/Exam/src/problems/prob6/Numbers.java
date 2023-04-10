package problems.prob6;


import java.util.ArrayList;
import java.util.List;

public class Numbers {
    final private int START = 50;
    final private int END = 100;
    final private int DECISION_MAKER = 0;
    List<Integer> numberList = new ArrayList<>();
    public Numbers(int DECISION_NUM) {
        for (int i = START; i <= END; i++) {
            if (i % DECISION_NUM == DECISION_MAKER) {
                numberList.add(i);
            }
        }
    }

    @Override
    public String toString() {
        return "Numbers{" +
                "numberList=" + numberList +
                '}';
    }
}
