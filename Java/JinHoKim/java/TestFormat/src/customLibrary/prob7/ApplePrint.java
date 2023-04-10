package customLibrary.prob7;

import customLibrary.utility.CustomRandom;

public class ApplePrint {
    final int applePrice = 2000;
    double emotion;
    double realApplePrice;

    public void applePriceRandom() {
        emotion = CustomRandom.generateNumber(3, 20);
        realApplePrice = (emotion * applePrice) * 0.01 + applePrice;
        System.out.println("주인 기분따라 3 ~ 20 %까지" +
                "랜덤으로 인상하여 파는 랜덤 사과 가격: " + realApplePrice);

    }
}
