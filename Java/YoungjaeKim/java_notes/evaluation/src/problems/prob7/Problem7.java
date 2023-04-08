package problems.prob7;

import customLibrary.CustomRandom;

public class Problem7 {
    public static void main (String[] args) {
        final int APPLE_COST_MIN = 3;
        final int APPLE_COST_MAX = 20;
        final int apple = 2000;
        double increase = 0;
        int appleCost = 0;

        increase = 1 + ((double) CustomRandom.generateNumber(APPLE_COST_MIN, APPLE_COST_MAX) / 100);
        appleCost = (int) (apple * increase);
        System.out.println("가격 인상률 : " + increase);
        System.out.println("최종 사과 가격 : " + appleCost);
    }
}
