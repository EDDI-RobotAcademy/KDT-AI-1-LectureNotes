package practice.bank2;

import utility.random.CustomRandom;

public class RandomJumpSum {
    public static void main(String[] args) {
        final int START = 1;
        final int END = 101;
        final int RANDOM_START = 2;
        final int RANDOM_END = 10;
        int randomNumber = 0;
        int totalSum = START;

        for (int i = START; i < END;) {
            randomNumber = CustomRandom.generateNumber(2, 10);
            i += randomNumber;
            totalSum += i;
            System.out.println("랜덤: " + randomNumber);
            System.out.println("현재: " + i);
            System.out.println("합은: " + totalSum);
        }
        System.out.println(totalSum);
    }
}
