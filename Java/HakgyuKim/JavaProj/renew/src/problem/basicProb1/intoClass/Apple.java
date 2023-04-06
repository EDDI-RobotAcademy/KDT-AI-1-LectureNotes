package problem.basicProb1.intoClass;

import utility.random.CustomRandom;

public class Apple {

    final int MIN_PRICE = 5000;
    final int MAX_PRICE = 10000;

    final int applePrice;

    public Apple() {
        applePrice = CustomRandom.generateNumber(MIN_PRICE, MAX_PRICE);
        }

    public int getApplePrice() {
        return applePrice;
    }
}


