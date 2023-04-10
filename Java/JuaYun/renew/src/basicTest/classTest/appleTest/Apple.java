package basicTest.classTest.appleTest;

import utility.random.CustomRandom;

public class Apple {
    int APPLE_MAX = 5;
    int APPLE_MIN = 3;
    int AppleNum = CustomRandom.generateNumber(APPLE_MIN, APPLE_MAX);

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
