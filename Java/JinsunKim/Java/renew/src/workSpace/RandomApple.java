package workSpace;


import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class RandomApple {

    final int appleMinCost;
    final int appleMaxCost;

    List<Integer> appleCostList;

    final int ACQUIRE_MIN = 3;
    final int ACQUIRE_MAX = 5;

    int realAcquireNumber;


    public RandomApple (int appleMinCost, int appleMaxCost) {
        this.appleMinCost = appleMinCost;
        this.appleMaxCost = appleMaxCost;

        appleCostList = new ArrayList<>();
    }

    public void acquireApples() {
        realAcquireNumber = CustomRandom.generateNumber(ACQUIRE_MIN, ACQUIRE_MAX);

        for (int i = 0; i < realAcquireNumber; i++) {
            int randomAppleCost =
                    CustomRandom.generateNumber(appleMinCost, appleMaxCost);
            System.out.println("사과 가격 : " + randomAppleCost);
            appleCostList.add(randomAppleCost);
        }
    }


    public int calculateCost() {
        int tmpsum = 0;
        for (int i = 0; i < appleCostList.size(); i++ ){
            tmpsum += appleCostList.get(i);
        }
        return tmpsum;
    }

}
