package practice.bank2;

import utility.random.CustomRandom;

public class RandomTimesSum {
    public static void main(String[] args) {
        final int START = 1;
        final int END = 101;
        final int RANDOM_START = 2;
        final int RANDOM_END = 10;
        int randomNumber = 0;
        int totalSum = 0;

        for (int i = START; i < END; i++) {
            randomNumber = CustomRandom.generateNumber(2, 10);
            totalSum += i * randomNumber;
        }
        System.out.println(totalSum);
    }
}
