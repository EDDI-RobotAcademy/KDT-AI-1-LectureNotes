package homework.basic.randomApple;

import utilityRandom.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class RandomApple {
    final int appleMinCost;
    final int appleMAxCost;

    final int ACQUIRE_MIN=3;
    final int ACQUIRE_MAX=5;
    int realAcquireNumber;
    List<Integer> appleCostList;

    public RandomApple(int appleMinCost, int appleMAxCost) {
        this.appleMinCost = appleMinCost;
        this.appleMAxCost = appleMAxCost;

        appleCostList=new ArrayList<>();
    }

    public void acquireAplles() {
        realAcquireNumber= CustomRandom.generateNumber(ACQUIRE_MIN,ACQUIRE_MAX);

        for (int i=0;i<realAcquireNumber;i++){
            int randomAppleCost=CustomRandom.generateNumber(appleMinCost,appleMAxCost);
            appleCostList.add(randomAppleCost);

    }
}

    public int calculateCost() {
        int tmpSum=0;
                for(int i=0;i<appleCostList.size();i++){
                    tmpSum+=appleCostList.get(i);
                }
                return tmpSum;
    }
}
