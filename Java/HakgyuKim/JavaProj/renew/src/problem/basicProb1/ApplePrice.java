package problem.basicProb1;

import utility.random.CustomRandom;

class Apple {
    int applePrice;
    final int MIN = 5000;
    final int MAX = 10000;

    public Apple() {
        this.applePrice = CustomRandom.generateNumber(MIN, MAX);
    }

    public int getApplePrice() {
        return applePrice;
    }
}

public class ApplePrice {
    public static void main(String[] args) {
        final int MIN_APPLE = 3;
        final int MAX_APPLE = 5;
        final int APPLE_NUM = CustomRandom.generateNumber(MIN_APPLE, MAX_APPLE);
        Apple apple = new Apple();

        int appleTotalPrice = apple.getApplePrice() * APPLE_NUM;

        System.out.println(apple.getApplePrice());
        System.out.println(APPLE_NUM);
        System.out.println(appleTotalPrice);

    }
}
