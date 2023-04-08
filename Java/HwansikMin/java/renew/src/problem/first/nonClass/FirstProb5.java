package problem.first.nonClass;

import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class FirstProb5 {
    public static void main(String[] args) {
        final int APPLE_AQUIRE_MIN = 3;
        final int APPLE_AQUIRE_MAX = 5;

        final int appleAcquireNumber = CustomRandom.generateNumber(APPLE_AQUIRE_MIN, APPLE_AQUIRE_MAX);

        System.out.println("수확한 사과 개수: " + appleAcquireNumber);
    }
}