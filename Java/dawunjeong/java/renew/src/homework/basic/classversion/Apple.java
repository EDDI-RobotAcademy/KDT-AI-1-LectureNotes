package homework.basic.classversion;

import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class Apple {

    final int appleMinCost;
    final int appleMaxCost;
    final int ACQUIRE_MIN = 3;
    final int ACQUIRE_MAX = 5;
    List<Integer> appleCostList;
    int realAcquireNumber;

    public Apple(int appleMinCost, int appleMaxCost) {
        this.appleMinCost = appleMinCost;
        this.appleMaxCost = appleMaxCost;

        appleCostList = new ArrayList<>();
    }

    public void acquireApples(){
        realAcquireNumber = CustomRandom.generateNumber(ACQUIRE_MIN,ACQUIRE_MAX);

        for(int i = 0; i < realAcquireNumber; i++){
            int randomAppleCost = CustomRandom.generateNumber(appleMinCost,appleMaxCost);
            System.out.println("사과 가격: " + randomAppleCost);

            appleCostList.add(randomAppleCost);
        }
    }
    public int calculateCost(){
        int tmpSum = 0;
        for(int i = 0; i < appleCostList.size(); i++){
            tmpSum += appleCostList.get(i);
        } return tmpSum;
    }
}
