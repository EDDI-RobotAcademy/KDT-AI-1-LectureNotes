package basicTest.apple;

import utility.random.CustomRandom;

public class Apple {
    final int AppleMax = 5;
    final int AppleMin = 3;
    int AppleNum;

    public Apple() {
        AppleNum = CustomRandom.generateNumber(AppleMin, AppleMax);
    }

    public int getAppleNum() {
        return AppleNum;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "AppleNum=" + AppleNum +
                '}';
    }
}
