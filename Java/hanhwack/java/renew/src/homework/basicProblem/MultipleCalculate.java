package homework.basicProblem;

import java.util.ArrayList;
import java.util.List;

public class MultipleCalculate {
    private int num;
    private final int MAX_NUM = 100;
    private int multipleSum;
    List<Integer> multipleList = new ArrayList<>();

    public MultipleCalculate() {
        this.num = num;
        this.multipleList = multipleList;
    }

    public void setNum(int a) {
        num = a;
        multipleList.clear();
        for (int i = 0; i <= MAX_NUM ; i++) {
            if (i % num == 0) {
                multipleList.add(i);
            }

        }
    }

    public void getNum() {
        System.out.println(MAX_NUM + "이하 "+ num +"의 배수는 다음과 같다");
        for (int number: multipleList) {
            System.out.println(number);
        }
    }

    public void getMultipleSum() {
        System.out.println(MAX_NUM + "이하 "+ num +"의 배수의 합은 다음과 같다");
        for (int number: multipleList) {
            multipleSum += number;
        }
        System.out.println(multipleSum);

    }
}
