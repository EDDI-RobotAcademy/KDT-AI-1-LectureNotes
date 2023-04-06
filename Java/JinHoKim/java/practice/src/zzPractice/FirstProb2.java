package zzPractice;

import utility.Random;

import java.util.ArrayList;
import java.util.List;

public class FirstProb2 {
    final int appleMinCost;
    final int appleMaxCost;
    final int ACQUIRE_MIN = 3;
    final int ACQUIRE_MAX = 5;
    int realAcquireNumber;
    List<Integer> appleCostList;

    public FirstProb2(int appleMinCost, int appleMaxCost) {
        this.appleMinCost = appleMinCost;
        this.appleMaxCost = appleMaxCost;

        appleCostList = new ArrayList<>();
    }

    public void acquireApples() {
        realAcquireNumber = Random.generateNumber(ACQUIRE_MIN, ACQUIRE_MAX);
        for (int i = 0; i < realAcquireNumber; i++) {
            int randomAppleCost = Random.generateNumber(appleMinCost, appleMaxCost);
            System.out.println("사과 가격: " + randomAppleCost);
            appleCostList.add(randomAppleCost);
        }
    }
}
