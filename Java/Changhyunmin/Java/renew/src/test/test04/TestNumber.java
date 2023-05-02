package test.test04;

import java.util.ArrayList;
import java.util.List;

public class TestNumber {
    int MIN;
    int MAX;

    public TestNumber(int MIN, int MAX) {
        this.MIN = MIN;
        this.MAX = MAX;
    }
    public List TestNumberOne(int Even){
        List<Integer> NumberOne = new ArrayList<>();
        for (int i = MIN; i <= MAX; i++){
            if (i % Even == 0){
                NumberOne.add(i);
            }
        }
        return NumberOne;
    }
    public List TestNumberTwo(int Three){
        List<Integer> NumberTwo = new ArrayList<>();
        for (int i = MIN; i <= MAX; i++){
            if (i % Three == 0){
                NumberTwo.add(i);
            }
        }return NumberTwo;
    }
    public int TestNumberThree(int Four){
        int TotalNum = 0;
        for (int i = MIN; i <= MAX; i++){
            if (i % Four == 0){
                TotalNum += i;
            }
        }
        return TotalNum;
    }
}
