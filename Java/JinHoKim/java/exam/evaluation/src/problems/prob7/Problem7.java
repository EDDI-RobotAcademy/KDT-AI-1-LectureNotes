package problems.prob7;

import customLibrary.utility.random.CustomRandom;

public class Problem7 {
    public static void main(String[] args) {
        final int appleCost = 2000;
        final float increaseRate = CustomRandom.generateNumber(3, 20) / 100.0f;

        // newAppleCost = appleCost + appleCost * increaseRate
        // newAppleCost = appleCost * (1 + increaseRate)
        System.out.println("인상률: " + increaseRate);
        System.out.println("계산된 사과 가격: " + appleCost * (1 + increaseRate));
    }
}
