package practice;

import utility.Random;

import java.util.ArrayList;
import java.util.List;

public class RandomApple {
    final int appleMinCost;
    final int appleMaxCost;
    final int ACQUIRE_MIN = 3;
    final int ACQUIRE_MAX = 5;
    int realAcquireNumber;
    List<Integer> appleCostList;

    public RandomApple(int appleMinCost, int appleMaxCost) {
        this.appleMinCost = appleMinCost;
        this.appleMaxCost = appleMaxCost;

        appleCostList = new ArrayList<>();
    }

    public void acquireApple() {
        realAcquireNumber = Random.generateNumber(ACQUIRE_MIN, ACQUIRE_MAX);

        for (int i = 0; i < realAcquireNumber; i++) {
            int randomAppleCost = Random.generateNumber(appleMinCost, appleMaxCost);
            appleCostList.add(randomAppleCost);
            System.out.println("사과 가격: " + randomAppleCost);

        }
    }

    public int calculateCost() {
        int tmpSum = 0;

        for (int i = 0; i < appleCostList.size(); i++) {
            tmpSum += appleCostList.get(i);
        }
        return tmpSum;
    }
}