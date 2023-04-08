package problems.prob5;

import java.util.ArrayList;
import java.util.List;

public class NumberList {
    List<Integer> numberList = new ArrayList<>();
    public NumberList() {
        numberList.add(3);
        numberList.add(3);
        numberList.add(3);
        int newNum = 0;
        for (int i = 3; i < 21; i ++) {
            newNum = numberList.get(i - 1) + numberList.get(i - 3);
            numberList.add(newNum);
        }
    }

    public void getSpecificNum(int SpecificNumIdx) {
        System.out.println(numberList.get(SpecificNumIdx - 1));
    }

    @Override
    public String toString() {
        return "NumberList{" +
                "numberList=" + numberList +
                '}';
    }
}
