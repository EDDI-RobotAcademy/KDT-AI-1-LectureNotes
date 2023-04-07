package basic;
// 1 ~ 100까지 숫자중 3의 배수만 출력해보자!

import java.util.ArrayList;
import java.util.List;

public class Basic2 {


    public static void main(String[] args) {
        List<Integer> numberList = new ArrayList<>();
        int number_MIN = 1;
        int number_MAX = 100;

        for (int i = number_MIN; i <= number_MAX; i++) {
            if (i % 3 == 0) {
                numberList.add(i);
            }
        }
        System.out.println(numberList);
    }
}


