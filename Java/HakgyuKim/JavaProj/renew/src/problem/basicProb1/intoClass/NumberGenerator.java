package problem.basicProb1.intoClass;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    int MIN;
    int MAX;
    int DECISION_NUM;
    int DECISION_MAKER = 0;
    int numberSum = 0;
    List<Integer> numberList = new ArrayList<>();
    public NumberGenerator(int MIN, int MAX, int DECISION_NUM) {
        this.MIN = MIN;
        this.MAX = MAX;
        this. DECISION_NUM = DECISION_NUM;
        for (int i = MIN; i <= MAX; i++) {
            if (i % DECISION_NUM == DECISION_MAKER) {
                numberList.add(i);
                numberSum += i;
            }
        }
    }

    public void getNumberList() {
        System.out.println(numberList);
    }

    public void getNumberSum() {
        System.out.println(numberSum);
    }
}
