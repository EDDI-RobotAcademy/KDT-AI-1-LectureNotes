package problems.prob6;

import java.util.ArrayList;
import java.util.List;

public class MultipleNum {
    private int num;
    private final int MAX_NUM = 100;
    private final int MIN_NUM = 50;
    List<Integer> multipleList = new ArrayList<>();

    private int multipleSum;

    public MultipleNum() {
        this.num = num;
        this.multipleList = multipleList;
    }

    public void setNum(int a) {
        num = a;
        multipleList.clear();
        for (int i = MIN_NUM; i <= MAX_NUM; i++) {
            if (i % num == 0) {
                multipleList.add(i);
            }
        }
    }
    public void getMultipleNum() {
        System.out.println(MIN_NUM + "이상 " + MAX_NUM + "이하 "+ num +"의 배수는 다음과 같다");
        for (int number: multipleList) {
            System.out.println(number);
        }
    }
    public void getMultipleSum() {
        System.out.println(MIN_NUM + "이상 " + MAX_NUM + "이하에서의 합은 다음과 같다");
        for (int number: multipleList) {
            multipleSum += number;
        }
        System.out.println(multipleSum);

    }
}
