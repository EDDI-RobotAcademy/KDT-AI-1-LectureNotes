package problem.first.nonClass;

import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class FirstProb6 {
    public static void main(String[] args) {
        final int APPLE_COST_MIN = 5000;
        final int APPLE_COST_MAX = 10000;

        final int APPLE_AQUIRE_MIN = 3;
        final int APPLE_AQUIRE_MAX = 5;

        final int appleAcquireNumber = CustomRandom.generateNumber(APPLE_AQUIRE_MIN, APPLE_AQUIRE_MAX);
        System.out.println("수확한 사과 개수: " + appleAcquireNumber);

        int appleCostSum = 0;

        for (int i = 0; i < appleAcquireNumber; i++) {
            final int appleCost = CustomRandom.generateNumber(APPLE_COST_MIN, APPLE_COST_MAX);
            System.out.println("사과 가격: " + appleCost);

            appleCostSum += appleCost;
        }

        System.out.println("수확한 사과의 전체 가격: " + appleCostSum);
    }
}
