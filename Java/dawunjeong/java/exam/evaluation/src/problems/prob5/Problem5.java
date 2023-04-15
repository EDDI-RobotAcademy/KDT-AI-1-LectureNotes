package problems.prob5;

import java.util.ArrayList;
import java.util.List;

// 문제 5번
class NumberList{
    final private List<Integer> numberList = new ArrayList<>();
    public NumberList() {
        numberList.add(3);
        numberList.add(3);
        numberList.add(3);
        numberList.add(6);

        for(int i = 4; i < 30; i++){
            numberList.add(numberList.get(i-4) + numberList.get(i-3) + numberList.get(i-2));
        }
    }

    public int getNumberList(int index) {
        return numberList.get(index);
    }

    @Override
    public String toString() {
        return "NumberList{" +
                "numberList=" + numberList +
                '}';
    }
}

public class Problem5 {
    public static void main(String[] args) {
        NumberList numberList = new NumberList();
        int findIndexNumber = 20;
        int bias = 1;
        System.out.println(numberList);
        System.out.println(numberList.getNumberList(findIndexNumber - bias));
    }
}
