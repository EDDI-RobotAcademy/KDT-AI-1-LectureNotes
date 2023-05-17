package basicTest;

import utility.random.CustomRandom;

public class FirstProb5 {
    public static void main(String[] args) {

    int APPLE_NUM_MAX = 5;
    int APPLE_NUM_MIN = 3;

    int appleNum = CustomRandom.generateNumber(APPLE_NUM_MIN, APPLE_NUM_MAX);
        System.out.println(appleNum);
    }
}
