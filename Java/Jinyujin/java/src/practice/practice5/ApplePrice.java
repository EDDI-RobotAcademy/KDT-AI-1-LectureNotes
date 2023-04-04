package practice.practice5;

import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class ApplePrice {
    private int applePrice;

    public int getApplePrice() {
        return applePrice;
    }

    final private int MIN_PRICE = 5000;
    final private int MAX_PRICE = 10000;

    private int priceSum = 0;

    public ApplePrice() {

        // 사과의 가격은 5000~10000 사이의 랜덤값
        applePrice = CustomRandom.generateNumber(MIN_PRICE, MAX_PRICE);
    }

    @Override
    public String toString() {
        return "ApplePrice{" +
                "applePrice=" + applePrice +
                '}';
    }
}
