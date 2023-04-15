package problems.prob15;

import java.util.ArrayList;
import java.util.List;

public class SpecialNumberList {
    final private int DECISION_NUM = 2;
    final private int ODD = 1;
    private List<Integer> numberList;

    public SpecialNumberList() {
        numberList = new ArrayList<>();
        for (int i = 0; ; i++) {
            if (i % DECISION_NUM == ODD) {
                numberList.add(i);
            }
        }
    }
    public void getSpecialNumber(int specialNumberIdx) {
        System.out.println(numberList.get(specialNumberIdx - 1));
    }
}
