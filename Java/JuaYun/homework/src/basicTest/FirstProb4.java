package basicTest;

import utility.random.CustomRandom;

// 사과 가격 뽑기
public class FirstProb4 {
    public static void main(String[] args) {

    int APPLE_PRICE_MAX = 10000;
    int APPLE_PRICE_MIN = 5000;

    final int applePrice = CustomRandom.generateNumber(APPLE_PRICE_MIN, APPLE_PRICE_MAX);

        System.out.println(applePrice);
    }
}
