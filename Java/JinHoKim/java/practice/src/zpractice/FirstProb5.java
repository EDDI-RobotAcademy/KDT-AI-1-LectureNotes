package zpractice;

import utility.Random;

public class FirstProb5 {
    public static void main(String[] args) {
        final int APPLE_AQUIRE_MIN = 3;
        final int APPLE_AQUIRE_MAX = 5;

        final int appleAcquireNumber = Random.generateNumber(APPLE_AQUIRE_MIN, APPLE_AQUIRE_MAX);

        System.out.println("수확한 사과 개수: " + appleAcquireNumber);
    }
}
