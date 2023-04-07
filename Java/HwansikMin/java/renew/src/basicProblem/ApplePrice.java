package basicProblem;

import java.util.Random;
public class ApplePrice {
    public static void main(String[] args) {
        final int START = 0;
        final int MAX = 10000;
        final int MIN = 5000;
        final int RandomApplePrice
                = (int)(Math.random()*(MAX - MIN + 1)) + MIN;

        System.out.println("RandomApplePrice = " + RandomApplePrice);

    }
}
