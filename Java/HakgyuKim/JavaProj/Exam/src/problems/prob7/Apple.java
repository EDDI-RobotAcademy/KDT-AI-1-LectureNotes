package problems.prob7;

import customLibrary.CustomRandom;

public class Apple {
    final private int applePrice = 2000;
    final private float applePriceIncreaseRate = 0.01f * CustomRandom.generateNumber(3,20);

    public void getApplePrice() {
        float newApplePrice = applePrice + (applePrice * applePriceIncreaseRate);
        System.out.println("사과의 가격은: " + newApplePrice);
    }
    public void getPriceIncreaseRate() {
        System.out.println("가격의 인상률은: " + (int)(applePriceIncreaseRate * 100) + "%");
    }
}
