package testTest;

import java.util.ArrayList;
import java.util.List;


public class TestClass {
    int MAX;

    public TestClass(int MAX) {
        this.MAX = MAX;
    }

    public List<Integer> Test_Q (int THREE, int FIVE) {
        List<Integer> Test_Q = new ArrayList<>();

        for (int i = 0; i < MAX; i++) {
            if ((i % THREE == 0) || (i % FIVE == 0)) {
                Test_Q.add(i);
            }
        }
        return Test_Q;
    }
    public int TestSum_Q(int THREE, int FIVE){
        int Total = 0;
        for (int j = 0; j < MAX; j++) {
            if ((j % THREE == 0) || (j % FIVE == 0)) {
                Total += j;
            }
        }
        return Total;
    }
}




