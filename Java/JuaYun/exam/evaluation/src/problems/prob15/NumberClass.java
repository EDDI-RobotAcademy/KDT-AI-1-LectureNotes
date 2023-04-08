package problems.prob15;

import java.util.ArrayList;
import java.util.List;

public class NumberClass {
    int MIN = 1;
    int MAX = 1000;
    int Number = 273;
    int bias = 1;
    private int EVEN = 2;
    List<Integer> findNum = new ArrayList<>();

    public NumberClass() {
        for (int i = MIN; i <= MAX; i+= EVEN) {
            findNum.add(i);
        }
        System.out.println(findNum);
    }

    public void findNumberKey() {
        System.out.println(findNum.get(Number-bias));
    }
}
