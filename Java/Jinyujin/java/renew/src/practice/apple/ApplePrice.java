package practice.apple;

import utility.random.CustomRandom;

// 사과의 가격을 5000 ~ 10000 사이의 랜덤값
public class ApplePrice {
    final private int MIN_PRICE = 5000;
    final private int MAX_PRICE = 10000;
    private int applePrice;

    public int getApplePrice() {
        return applePrice;
    }

    public ApplePrice() {
        applePrice = CustomRandom.generateNumber(MIN_PRICE, MAX_PRICE);
    }

    @Override
    public String toString() {
        return '{' +
                "사과 가격 = " + applePrice +
                '}';
    }
}
