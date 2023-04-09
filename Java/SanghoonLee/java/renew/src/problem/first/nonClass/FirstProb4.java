package problem.first.nonClass;

import utility.random.CustomRandom;

public class FirstProb4 {
    public static void main(String[] args) {
        final int APPLE_COST_MIN = 5000;
        final int APPLE_COST_MAX = 10000;

        // 사과: 5000 ~ 10000
        final int appleCost = CustomRandom.generateNumber(APPLE_COST_MIN, APPLE_COST_MAX);
        System.out.println("사과 가격: " + appleCost);
    }
}
