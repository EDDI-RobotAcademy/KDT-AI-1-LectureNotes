package basic.classVersion.practiceYu;

import java.util.ArrayList;
import java.util.List;

public class ClassBasic {
    int MAX=0;
    int MIN=0;



    public ClassBasic(int MIN,int MAX) {
        this.MAX = MAX;
        this.MIN = MIN;

    }

    public List<Integer> findNumber(int DECISION_NUM) {
        List<Integer> numberList = new ArrayList<>();
        for (int i = MIN; i <= MAX; i++) {
            if (i % DECISION_NUM == 0) {
                numberList.add(i);

            }

        }
        return numberList;
    }

    public int findNumberSum(int DECISION_NUM) {
        int tmpNumberSum = 0;
        for (int i = MIN; i <= MAX; i++) {
            if (i % DECISION_NUM == 0) {
                tmpNumberSum += i;
            }

        }return tmpNumberSum;

    }
    }

