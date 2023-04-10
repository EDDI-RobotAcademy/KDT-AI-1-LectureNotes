package problems.prob15;

// 문제 15번

import java.util.ArrayList;
import java.util.List;

class OddNumber{
    final private int oddNumberCheck = 2;
    final private List<Integer> oddNumberList = new ArrayList<>();

    public OddNumber() {
        for(int i = 0; i < 1000; i++){
            if(i % oddNumberCheck == 1){
                oddNumberList.add(i);
            }
        }
    }

    public int getOddNumber(int index) {
        return oddNumberList.get(index);
    }

    @Override
    public String toString() {
        return "OddNumber{" +
                "oddNumberList=" + oddNumberList +
                '}';
    }
}
public class Problem15 {
    public static void main(String[] args) {
        OddNumber oddNumber = new OddNumber();
        final int findIndex = 273;
        final int bias = 1;
        System.out.println(oddNumber.getOddNumber(findIndex - bias));
    }
}
