package test2.arrayList;

import java.util.ArrayList;
import java.util.List;

public class ArrayListEx2 {
    public static void main(String[] args) {
        List<Integer> numberList = new ArrayList<>();
        int tmpSum = 0;
        int Number = 0;
        for (int i = 1; i <= 10; i++) {
            numberList.add(i);
        }
        for (int j = 0; j < 10; j++) {
            tmpSum += numberList.get(j);
            System.out.println( j + "번째 숫자: " + numberList.get(j)+", 추가하면서 숫자들을 더하면 "+ tmpSum);
        }

    }
}
