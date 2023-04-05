package zpractice;

import utility.Random;

public class FirstProb6 {
    public static void main(String[] args) {
        final int APPLE_COST_MIN = 5000;
        final int APPLE_COST_MAX = 10000;

        final int APPLE_ACQUIRE_MIN = 3;
        final int APPLE_ACQUIRE_MAX = 5;

        final int appleAcquireNumber = Random.generateNumber(APPLE_ACQUIRE_MIN, APPLE_ACQUIRE_MAX);

        System.out.println("수확한 사과 개수: " + appleAcquireNumber);

        int appleCostSum = 0;

        for (int i = 0; i < appleAcquireNumber; i++) {
            final int appleCost = Random.generateNumber(APPLE_COST_MIN, APPLE_COST_MAX);
            System.out.println("사과 가격: " + appleCost);

            appleCostSum += appleCost;
        }

        System.out.println("수확한 사과의 전체 가격: " + appleCostSum);

    }
}
